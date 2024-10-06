package com.example.pr1;

public class MyRunnable implements Runnable {
    @Override
    public void run() {
        System.out.println("Runnable is created. Thread name is: " + Thread.currentThread().getName());
    }
}
