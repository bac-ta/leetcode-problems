package system_designs.rate_limiter;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Per-key rate limiter, e.g. per user ID or IP address.
 * Each key gets its own TokenBucket instance.
 */
public class RateLimiter {

    private final double capacity;
    private final double refillRate;
    private final Map<String, TokenBucket> buckets = new ConcurrentHashMap<>();

    public RateLimiter(double capacity, double refillRate) {
        this.capacity = capacity;
        this.refillRate = refillRate;
    }

    private TokenBucket getBucket(String key) {
        return buckets.computeIfAbsent(key, k -> new TokenBucket(capacity, refillRate));
    }

    public boolean isAllowed(String key) {
        return isAllowed(key, 1);
    }

    public boolean isAllowed(String key, double cost) {
        return getBucket(key).allow(cost);
    }

    public double timeUntilAllowed(String key) {
        return timeUntilAllowed(key, 1);
    }

    public double timeUntilAllowed(String key, double cost) {
        return getBucket(key).retryAfterSeconds(cost);
    }

    // Example usage
    public static void main(String[] args) {
        // Allow 5 requests/sec, burst up to 10, per user
        RateLimiter limiter = new RateLimiter(10, 5);
        String user = "user_123";

        for (int i = 1; i <= 15; i++) {
            if (limiter.isAllowed(user)) {
                System.out.println("Request " + i + ": allowed");
            } else {
                double wait = limiter.timeUntilAllowed(user);
                System.out.printf("Request %d: denied, retry after %.2fs%n", i, wait);
            }
        }
    }
}