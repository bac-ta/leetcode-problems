package hashing;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.SortedMap;
import java.util.concurrent.ConcurrentSkipListMap;

/**
 * Consistent Hashing with virtual nodes and basic replica lookup (N).
 *
 * Improvements over the naive version:
 *  - ConcurrentSkipListMap instead of TreeMap -> thread-safe for
 *    concurrent reads (getNodesForKey) and writes (addServer/removeServer).
 *  - getNodesForKey(key, n) returns up to N DISTINCT physical servers,
 *    walking clockwise from the key's position — this is what a real
 *    key-value store uses to pick replica targets (see N/W/R quorum
 *    model in Dynamo-style systems).
 *
 * Still simplified for illustration:
 *  - Uses MD5 instead of a faster non-cryptographic hash
 *    (MurmurHash3 / xxHash are the usual production choice).
 *  - No collision handling on the ring.
 *  - No automatic failure detection (gossip/heartbeat) — addServer/
 *    removeServer must be called externally.
 */
public class ConsistentHashing {

    // The hash ring: position (Long) -> physical server name
    private final ConcurrentSkipListMap<Long, String> ring = new ConcurrentSkipListMap<>();

    // Number of virtual nodes per physical server
    private final int virtualNodesPerServer;

    public ConsistentHashing(int virtualNodesPerServer) {
        this.virtualNodesPerServer = virtualNodesPerServer;
    }

    /** Hash an arbitrary string into a Long (MD5, first 8 bytes). */
    private long hash(String input) {
        try {
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            byte[] digest = md5.digest(input.getBytes());
            long hashValue = 0;
            for (int i = 0; i < 8; i++) {
                hashValue = (hashValue << 8) | (digest[i] & 0xFF);
            }
            return Math.abs(hashValue);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    /** Add a physical server -> creates its virtual nodes on the ring. */
    public void addServer(String serverName) {
        for (int i = 0; i < virtualNodesPerServer; i++) {
            long position = hash(serverName + "#" + i);
            ring.put(position, serverName);
        }
    }

    /** Remove a physical server -> removes all of its virtual nodes. */
    public void removeServer(String serverName) {
        for (int i = 0; i < virtualNodesPerServer; i++) {
            long position = hash(serverName + "#" + i);
            ring.remove(position);
        }
    }

    /** Find the single primary server responsible for a key. */
    public String getServerForKey(String key) {
        List<String> servers = getNodesForKey(key, 1);
        return servers.isEmpty() ? null : servers.get(0);
    }

    /**
     * Find up to N distinct physical servers for a key, walking
     * clockwise from the key's hash position. This is the lookup
     * used to pick replica targets under an N/W/R quorum scheme.
     */
    public List<String> getNodesForKey(String key, int n) {
        List<String> result = new ArrayList<>();
        if (ring.isEmpty() || n <= 0) {
            return result;
        }

        long keyPosition = hash(key);
        // LinkedHashSet keeps insertion order and dedups physical servers
        // (multiple virtual nodes can map to the same physical server).
        Set<String> distinctServers = new LinkedHashSet<>();

        SortedMap<Long, String> clockwise = ring.tailMap(keyPosition);
        List<Long> orderedPositions = new ArrayList<>(clockwise.keySet());
        orderedPositions.addAll(ring.headMap(keyPosition).keySet()); // wrap around

        for (Long position : orderedPositions) {
            distinctServers.add(ring.get(position));
            if (distinctServers.size() == n) {
                break;
            }
        }

        result.addAll(distinctServers);
        return result;
    }

    // ---- Demo ----
    public static void main(String[] args) {
        // 5 virtual nodes here just for a short demo; production
        // systems typically use 100-200 per physical server.
        ConsistentHashing ch = new ConsistentHashing(5);

        ch.addServer("ServerA");
        ch.addServer("ServerB");
        ch.addServer("ServerC");
        ch.addServer("ServerD");

        String key = "user_101";
        int replicationFactor = 3; // N = 3

        System.out.println("Primary server for \"" + key + "\": "
                + ch.getServerForKey(key));
        System.out.println("Replica set (N=" + replicationFactor + ") for \""
                + key + "\": " + ch.getNodesForKey(key, replicationFactor));

        System.out.println("\nServerB goes down, removing from cluster...");
        ch.removeServer("ServerB");

        System.out.println("Replica set (N=" + replicationFactor + ") for \""
                + key + "\" after failure: "
                + ch.getNodesForKey(key, replicationFactor));
    }
}