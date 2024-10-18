package org.example.app;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class SharedResource {
    private final ReadWriteLock readWriteLock = new ReentrantReadWriteLock();

    public void readLock(){
//        readWriteLock.readLock().lock();
        Lock lock = readWriteLock.readLock();
        lock.lock();
        try{
            // perform some read operations
        } finally {
            readWriteLock.readLock().unlock();
        }
    }

    public void writeLock(){
        try{
            // perform some write operations
        } finally {
//            readWriteLock.readLock().unlock();
            Lock lock = readWriteLock.readLock();
            lock.unlock();
        }
    }
}
