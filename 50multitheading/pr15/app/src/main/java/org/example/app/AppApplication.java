package org.example.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AppApplication {

    public static void main(String[] args) throws InterruptedException {
        Object lock = new Object();

        // this does not work
//        synchronized (lock) {
//            System.out.println("Before waiting...");
//            lock.wait();
//            System.out.println("After waiting...");
////            lock.notify();
//        }

        Thread thread = new Thread(() -> {
            System.out.println("Before notify..."); // 2
            synchronized (lock) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                lock.notify();
            }
            System.out.println("After notify..."); // 3
        });
        thread.start();
        // the code is read from top t bottom
        synchronized (lock) {
            System.out.println("Before waiting..."); // 1
            lock.wait();
            System.out.println("After waiting..."); // 3
//            lock.notify();
        }
    }

}
