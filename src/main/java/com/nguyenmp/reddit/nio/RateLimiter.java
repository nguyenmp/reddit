package com.nguyenmp.reddit.nio;

public class RateLimiter {
    private static final long TIMEOUT = 2 * 1000; // 2 seconds = 2000 millis

    private static volatile long lastRun = 0L;
    public static synchronized void enqueue() {
        long currentRun = System.currentTimeMillis();

        if (lastRun + TIMEOUT > currentRun) {
            // We need to wait
            try {
                Thread.sleep(TIMEOUT - (currentRun - lastRun));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        lastRun = currentRun;
    }
}
