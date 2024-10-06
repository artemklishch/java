package com.example.pr1;

import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Pr1Application {
    public static void main(String[] args) {
        Thread thread = new MyThread("my thread 1");
        thread.start();

        MyRunnable myRunnable = new MyRunnable();
//        Thread runnableThread = new Thread(myRunnable);
        Thread runnableThread = new Thread(myRunnable, "runnable 1");
        runnableThread.start();
    }

}

class MyRunnable implements Runnable {
    @Override
    public void run() {
        System.out.println("MyRunnable is created. Thread name is: " + Thread.currentThread().getName()); // Thread-0 or runnable 1
    }
}

class MyThread extends Thread {
    public MyThread(String name) {
        super(name);
    }

    @Override
    public void run() {
        System.out.println("Thread is created. Thread name is: " + Thread.currentThread().getName()); //  my thread 1
    }
}
