package org.example.app;

//import java.util.concurrent.TimeUnit;
//import java.util.concurrent.locks.Lock;
//import java.util.concurrent.locks.ReentrantLock;
//
//public class DeadlockWithTryLock {
//    // Two resource objects
//    private static final Lock lock1 = new ReentrantLock();
//    private static final Lock lock2 = new ReentrantLock();
//
//    public static void main(String[] args) {
//        Thread t1 = new Thread(() -> {
//            try {
//                if (lock1.tryLock(500, TimeUnit.MILLISECONDS)) {
//                    try {
//                        System.out.println("Thread 1: Locked Resource 1");
//
//                        Thread.sleep(100); // Simulate work
//
//                        if (lock2.tryLock(500, TimeUnit.MILLISECONDS)) {
//                            try {
//                                System.out.println("Thread 1: Locked Resource 2");
//                            } finally {
//                                lock2.unlock();
//                            }
//                        } else {
//                            System.out.println("Could not obtain lock2 by Thread 1 and complete the method. "
//                                    + "Consider handling such case in your application according to the business logic!");
//                        }
//                    } finally {
//                        lock1.unlock();
//                    }
//                } else {
//                    System.out.println("Could not obtain lock1 by Thread 1 and complete the method. "
//                            + "Consider handling such case in your application according to the business logic!");
//                }
//            } catch (InterruptedException e) {
//                Thread.currentThread().interrupt();
//                throw new RuntimeException(e);
//            }
//        });
//
//        Thread t2 = new Thread(() -> {
//            try {
//                if (lock2.tryLock(500, TimeUnit.MILLISECONDS)) {
//                    try {
//                        System.out.println("Thread 2: Locked Resource 2");
//
//                        Thread.sleep(100); // Simulate work
//
//                        if (lock1.tryLock(500, TimeUnit.MILLISECONDS)) {
//                            try {
//                                System.out.println("Thread 2: Locked Resource 1");
//                            } finally {
//                                lock1.unlock(); // Always unlock in a finally block
//                            }
//                        } else {
//                            System.out.println("Could not obtain lock1 by Thread 2 and complete the method. "
//                                    + "Consider handling such case in your application according to the business logic!");
//                        }
//                    } finally {
//                        lock2.unlock();
//                    }
//                } else {
//                    System.out.println("Could not obtain lock2 by Thread 2 and complete the method. "
//                            + "Consider handling such case in your application according to the business logic!");
//                }
//            } catch (InterruptedException e) {
//                Thread.currentThread().interrupt();
//                throw new RuntimeException(e);
//            }
//        });
//
//        // Start both threads
//        t1.start();
//        t2.start();
//    }
//}



import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class DeadLockWithTryLock {
    private static final Lock lock1 = new ReentrantLock();

    private static final Lock lock2 = new ReentrantLock();

    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            try {
                if (lock1.tryLock(500, TimeUnit.MILLISECONDS)) {
                    try {
                        System.out.println("Thread 1: Locked resource 1");
                        Thread.sleep(100);
                        if (lock2.tryLock(500, TimeUnit.MILLISECONDS)) {
                            try {
                                System.out.println("Thread 1: Locked resource 2");
                                Thread.sleep(100);
                            } finally {
                                lock2.unlock();
                            }
                        } else {
                            System.out.println("Could not obtain lock2 by Thread 1 and complete the method." +
                                    "Consider handling such case in your application according to the business logic!");
                        }
                    } finally {
                        lock1.unlock();
                    }
                } else {
                    System.out.println("Could not obtain lock1 by Thread 1 and complete the method." +
                            "Consider handling such case in your application according to the business logic!");
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new RuntimeException(e);
            }
        });
        Thread t2 = new Thread(() -> {
            try {
                if (lock2.tryLock(500, TimeUnit.MILLISECONDS)) {
                    try {
                        System.out.println("Thread 2: Locked resource 2");
                        Thread.sleep(100);
                        if (lock1.tryLock(500, TimeUnit.MILLISECONDS)) {
                            try {
                                System.out.println("Thread 2: Locked resource 1");
                                Thread.sleep(100);
                            } finally {
                                lock1.unlock();
                            }
                        } else {
                            System.out.println("Could not obtain lock2 by Thread 2 and complete the method." +
                                    "Consider handling such case in your application according to the business logic!");
                        }
                    } finally {
                        lock2.unlock();
                    }
                } else {
                    System.out.println("Could not obtain lock1 by Thread 2 and complete the method." +
                            "Consider handling such case in your application according to the business logic!");
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new RuntimeException(e);
            }
        });
        t1.start();
        t2.start();
    }
}
