package org.example.pr8.lock;

import java.util.concurrent.locks.ReentrantLock;

public class Counter {
    private int count;

    private final ReentrantLock lock = new ReentrantLock(true);

    public void increment(){
        lock.lock();
        try{
            // lockInterruptibly - method for interupting the thread
            count++;
        } finally {
            lock.unlock();
        }
    }

    public int getCount(){
        return count;
    }
}