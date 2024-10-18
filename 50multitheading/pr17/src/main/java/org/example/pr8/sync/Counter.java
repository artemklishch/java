package org.example.pr8.sync;

public class Counter {
    private final Object lock = new Object();

    private int count;

    public void increment(){
        synchronized (lock){
            count++;
        }
    }

    public int getCount(){
        return count;
    }
}

