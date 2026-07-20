package algorithm_patterns.lru;

import java.util.HashMap;
import java.util.Map;

public class LRUCache<K,V> {
    private static class Node<K, V> {
        K key;
        V value;

        Node<K, V> prev, next;
        Node (K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    private final int capacity;
    private final Map<K, Node<K,V>> map;
    private final Node<K, V> head;
    private final Node<K,V> tail;

    public LRUCache(int capacity) {
        this. capacity = capacity;
        this.map = new HashMap<>();
        this. head = new Node<>(null, null);
        this.tail = new Node<>(null, null);
        head.next = tail;
        tail.prev = head;
    }

    public synchronized V get(K key) {
        Node<K, V> node  = map.get(key);
        if (node ==null) return null;
        moveToFront(node);
        return node.value;
    }

    public synchronized void put(K key, V value) {
        Node<K, V> existing = map.get(key);
        if (existing !=null) {
            existing.value = value;
            moveToFront(existing);
            return;
        }

        if (map.size()>=capacity) {
            Node<K, V> lru = tail.prev;
            removeNode(lru);
            map.remove(lru.key);
        }

        Node<K, V> newNode = new Node<>(key, value);
        map.put(key, newNode);
        addToFront(newNode);
    }

    private void moveToFront(Node<K, V> node) {
        removeNode(node);
        addToFront(node);
    }

    private void addToFront(Node<K, V> node) {
        node.next = head.next;
        node.prev = head;
        head.next.prev = node;
        head.next = node;
    }

    private void removeNode(Node<K,V> node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    public static void main(String[] args) {
        LRUCache<Integer, String> cache = new LRUCache<>(3);
        cache.put(1, "A");
        cache.put(2, "B");
        cache.put(3, "C");
        cache.get(1);
        cache.put(4, "D"); // Delete 2 keys cause last recent used

        System.out.println(cache.get(2)); // null
        System.out.println(cache.get(1)); // A
        System.out.println(cache.get(4)); // D
    }
}
