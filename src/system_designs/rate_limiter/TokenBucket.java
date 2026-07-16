package system_designs.rate_limiter;

import java.util.concurrent.locks.ReentrantLock;

/**
 * A single token bucket. Typically, one instance per user/key.
 * Refills continuously at `refillRate` tokens/second, up to `capacity`.
 */
public class TokenBucket {
    private final double capacity;
    private final double refillRate; // tokens per second
    private double tokens;
    private long lastRefillNanos;
    private final ReentrantLock lock = new ReentrantLock();

    public TokenBucket(double capacity, double refillRate) {
        this.capacity = capacity;
        this.refillRate = refillRate;
        this.tokens = capacity;
        this.lastRefillNanos = System.nanoTime();
    }

    private void refill() {
        long now = System.nanoTime();
        double elapsedSeconds = (now - lastRefillNanos) / 1_000_000_000.0;
        tokens = Math.min(capacity, tokens + elapsedSeconds * refillRate);
        lastRefillNanos = now;
    }

    /**
     * Attempts to consume `cost` tokens. Returns true if allowed.
     */
    public boolean allow(double cost) {
        lock.lock();
        try {
            refill();
            if (tokens >= cost) {
                tokens -= cost;
                return true;
            }
            return false;
        } finally {
            lock.unlock();
        }
    }

    /**
     * Seconds until enough tokens will be available for `cost`.
     */
    public double retryAfterSeconds(double cost) {
        lock.lock();
        try {
            refill();
            double deficit = cost - tokens;
            return deficit <= 0 ? 0.0 : deficit / refillRate;
        } finally {
            lock.unlock();
        }
    }
}