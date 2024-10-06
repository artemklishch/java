package com.example.pr1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Pr1Application {

    public static void main(String[] args) {
        System.out.println("Hello World");
//        Thread thread = new MyThread();
        Thread thread = new MyThread("my thread 1");
        thread.start();
//        SpringApplication.run(Pr1Application.class, args);
    }

}

class MyThread extends Thread {
    public MyThread(String name) {
        super(name);
    }

    @Override
    public void run() {
//        super.run();
        System.out.println("Thread is created. Thread name 1: " + this.getName()); // Thread-0 or custom name - 'my thread 1'
        System.out.println("Thread is created. Thread name 2: " + Thread.currentThread().getName()); // Thread-0 or custom name - 'my thread 1'
    }
}
