package org.example.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AppApplication {
    private static final Object res1 = new Object();

    private static final Object res2 = new Object();

    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            synchronized (res1) {
                System.out.println("Thread 1: Locked resource 1");
                try {
                    Thread.sleep(100); // simulate work
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    throw new RuntimeException(e);
                }
                synchronized (res2) {
                    System.out.println("Thread 1: Locked resource 2");
                }
            }
        });
        Thread t2 = new Thread(() -> {
            synchronized (res2) {
                System.out.println("Thread 2: Locked resource 2");
                try {
                    Thread.sleep(100); // simulate work
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    throw new RuntimeException(e);
                }
                synchronized (res1) {
                    System.out.println("Thread 2: Locked resource 1");
                }
            }
        });
        t1.start();
        t2.start();
    }

}
