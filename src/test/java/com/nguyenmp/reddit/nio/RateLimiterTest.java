package com.nguyenmp.reddit.nio;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class RateLimiterTest {

    @Test
    public void testEnqueue() {
        long last = 0;
        for (int i = 0; i < 10; i++) {
            RateLimiter.enqueue();
            long current = System.currentTimeMillis();
            assertTrue(current - last >= RateLimiter.TIMEOUT);
        }
    }

    @Test
    public void testThreadedEnqueue() throws InterruptedException {
        ArrayList<Thread> threads = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            threads.add(new Thread(new ThreadedRunnable()));
        }

        for (Thread thread : threads) {
            thread.start();
        }

        for (Thread thread : threads) {
            thread.join();
        }
    }

    volatile long last;
    private class ThreadedRunnable implements Runnable {
        @Override
        public void run() {
            for (int i = 0; i < 2; i++) {
                RateLimiter.enqueue();
                long current = System.currentTimeMillis();
                assertTrue(current - last >= RateLimiter.TIMEOUT);
                last = current;
            }
        }
    }
}