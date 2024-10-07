//package org.example.pr8;
//
//public class Counter {
//    private int count;
//
//    public synchronized void increment(){ // synchronizes between threads and makes them separate
//        count++;
//    }
//
//    public int getCount(){
//        return count;
//    }
//}


//package org.example.pr8;
//
//import java.util.concurrent.atomic.AtomicInteger;
//
//public class Counter {
//    private AtomicInteger count = new AtomicInteger(0);
//
//    public void increment(){
//        count.incrementAndGet();
//    }
//
//    public int getCount(){
//        return count.get();
//    }
//}

package org.example.pr8;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

public class Counter {
    private int count;

    private final ReentrantLock lock = new ReentrantLock();

    public void increment(){
        lock.lock();
        try{
            count++;
        } finally {
            lock.unlock();
        }
    }

    public int getCount(){
        return count;
    }
}
