package org.example.pr8;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Pr8Application {
    public static void main(String[] args) throws InterruptedException {
        SharedResource resource = new SharedResource();

        Thread thread1 = new Thread(() -> resource.access("Thread 1"));
        Thread thread2 = new Thread(() -> resource.access("Thread 2"));
        Thread thread3 = new Thread(() -> resource.access("Thread 3"));

        thread1.start();
        thread2.start();
        thread3.start();
    }
}

class SharedResource {
    private Object monitor = new Object();

    public void access(String threadName) {
        System.out.println("Hello!");
        synchronized (monitor) { // acquiring the monitor lock
            System.out.println(threadName + " entered synchronized block");
            try {
                // Simulate some work
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(threadName + " leaving synchronized block");
            // releasing the monitor block
        }
    }
}
