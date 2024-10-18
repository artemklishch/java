package org.example.app;

public class DeadLockWithLockOrdering {
    private static final String res1 = "abc"; // ми вказали тут String тому що в цього класу вже є
    // перевизначений метод compareTo, щоб зекономити час на цьому прикладі

    private static final String res2 = "dce";

    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            String firstLock = (res1.compareTo(res2) >= 0) ? res1 : res2;
            String secondLock = (res1.compareTo(res2) >= 0) ? res2 : res1;
            synchronized (firstLock) {
                System.out.println("Thread 1: Locked resource 1");
                try {
                    Thread.sleep(100); // simulate work
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    throw new RuntimeException(e);
                }
                synchronized (secondLock) {
                    System.out.println("Thread 1: Locked resource 2");
                }
            }
        });
        Thread t2 = new Thread(() -> {
            String firstLock = (res1.compareTo(res2) >= 0) ? res1 : res2;
            String secondLock = (res1.compareTo(res2) >= 0) ? res2 : res1;
            synchronized (firstLock) {
                System.out.println("Thread 2: Locked resource 2");
                try {
                    Thread.sleep(100); // simulate work
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    throw new RuntimeException(e);
                }
                synchronized (secondLock) {
                    System.out.println("Thread 2: Locked resource 1");
                }
            }
        });
        t1.start();
        t2.start();
    }
}
