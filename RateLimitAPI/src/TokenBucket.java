public class TokenBucket {
    double tokens;
    long lastRefillTime;

    public TokenBucket(double tokens, long lastRefillTime) {
        this.tokens = tokens;
        this.lastRefillTime = lastRefillTime;
    }
}
