package com.example.pr1;

import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Pr1Application {
    public static void main(String[] args) {
        System.out.println("Hello world! Current thread is: " + Thread.currentThread().getName()); // main
        Thread thread = new MyThread();
//        thread.start(); // Thread-0
        thread.run(); // main, новий потік не створюється
    }
}

class MyThread extends Thread {
    @Override
    public void run() {
        System.out.println("Thread is created! Thread name is: " + Thread.currentThread().getName());
    }
}

