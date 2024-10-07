package org.example.pr8;

import java.util.concurrent.atomic.AtomicInteger;

public class VolatileExampleThread extends Thread {
    private volatile boolean isRunning = true; // volatile is for atomacity and synchronization, in order to prevent cache value
    // common variable is in the main memory

    public void setRunning(boolean isRunning) {
        this.isRunning = isRunning;
    }

    @Override
    public void run() {
        long count = 0;
        while (isRunning) {
            count++;
        }
        System.out.printf("Thread terminated, count is %s%n", count);
    }
}
