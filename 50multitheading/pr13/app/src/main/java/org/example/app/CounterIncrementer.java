package org.example.app;

import java.time.LocalTime;

public class CounterIncrementer extends Thread {
    private final Counter counter;

    public CounterIncrementer(Counter counter, String name) {
        super(name);
        this.counter = counter;
    }

    @Override
    public void run() {
        System.out.printf("Thread %s started at: %s%n", Thread.currentThread().getName(), LocalTime.now());
        for (int i = 0; i < 100000000; i++) {
            counter.increment();
        }
        System.out.printf("Thread %s completed at %s%n", Thread.currentThread().getName(), LocalTime.now());
    }
}
