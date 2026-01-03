import java.util.concurrent.ConcurrentHashMap;

public class TokenBucketRateLimiter {

    private final int capacity;
    private final double refillRatePerMillis;

    private final ConcurrentHashMap<String, TokenBucket> buckets =
            new ConcurrentHashMap<>();

    public TokenBucketRateLimiter(int capacity, int refillRatePerSecond) {
        this.capacity = capacity;
        this.refillRatePerMillis = refillRatePerSecond / 1000.0;
    }

    public boolean allowRequest(String key) {
        long now = System.currentTimeMillis();

        buckets.putIfAbsent(key, new TokenBucket(capacity, now));
        TokenBucket bucket = buckets.get(key);

        synchronized (bucket) {
            refill(bucket, now);

            if (bucket.tokens >= 1) {
                bucket.tokens--;
                return true;
            }
            return false;
        }
    }

    private void refill(TokenBucket bucket, long now) {
        long elapsed = now - bucket.lastRefillTime;
        double tokensToAdd = elapsed * refillRatePerMillis;

        if (tokensToAdd > 0) {
            bucket.tokens = Math.min(capacity, bucket.tokens + tokensToAdd);
            bucket.lastRefillTime = now;
        }
    }
}
