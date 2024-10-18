//package org.example.pr20;
//
// there is deadlock error happens with this realization
//public class Philosopher implements Runnable {
//    private final Object leftFork;
//
//    private final Object rightFork;
//
//    public Philosopher(Object leftFork, Object rightFork) {
//        this.leftFork = leftFork;
//        this.rightFork = rightFork;
//    }
//
//    @Override
//    public void run() {
//        while (true) {
//            doAction("Thinking");
//            synchronized (leftFork) {
//                doAction("Picked up left fork");
//                synchronized (rightFork) {
//                    doAction("Picked up right fork - eating...");
//                    doAction("Put down right fork");
//                }
//                doAction("Put down left fork. Back to thinking");
//            }
//        }
//    }
//
//    private void doAction(String action) {
//        System.out.printf("%s %s%n", Thread.currentThread().getName(), action);
//        try {
//            Thread.sleep((int) (Math.random() * 100));
//        } catch (InterruptedException e) {
//            Thread.currentThread().interrupt();
//            throw new RuntimeException(e);
//        }
//    }
//}


package org.example.pr20;

import java.util.concurrent.Semaphore;

public class Philosopher implements Runnable {
    private final Semaphore semaphore;

    public Philosopher(Semaphore semaphore) {
        this.semaphore = semaphore;
    }

    @Override
    public void run() {
        while (true) {
            try {
                semaphore.acquire();
                doAction("Preparing to eat...");
                doAction("... eating ...");
                doAction("Final thoughts about the food");
                semaphore.release();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private void doAction(String action) {
        System.out.printf("%s %s%n", Thread.currentThread().getName(), action);
        try {
            Thread.sleep((int) (Math.random() * 100));
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }
    }
}
