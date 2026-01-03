public class Main {
    public static void main(String[] args) throws InterruptedException {

        // 5 tokens max, refill 1 token per second
        TokenBucketRateLimiter limiter =
                new TokenBucketRateLimiter(5, 1);

        String user = "user-1";

        for (int i = 1; i <= 10; i++) {
            boolean allowed = limiter.allowRequest(user);
            System.out.println("Request " + i + " → " + allowed);
            Thread.sleep(0); // simulate request gap
        }
    }
}
