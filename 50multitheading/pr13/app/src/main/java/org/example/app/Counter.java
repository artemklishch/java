package org.example.app;

public class Counter {
    private final Object lock = new Object();

    private final Object lock2 = new Object();

    private int value;

    private int value2;

    public synchronized void increment() {
        synchronized (lock) {
            value++;
        }
    }

    public synchronized void increment2() {
        synchronized (lock2) {
            value2++;
        }
    }

    public int getValue() {
        return value;
    }

    public int getValue2() {
        return value2;
    }
}
