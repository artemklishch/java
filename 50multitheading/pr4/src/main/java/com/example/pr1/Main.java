package com.example.pr1;

import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        Thread thread = new MyThread("my thread 1"); // new
        thread.start(); // runnable

        // when Thread.run() is called - running

        // can be:
        // - blocked;
        // from the blocked state the process can go to the previous state runnable, when invoke the method 'notify'
        // method interrupt()
        // - terminated; method interrupt(), can be this state after running state, if all logic there was executed

        MyRunnable myRunnable = new MyRunnable();
        Thread runnableThread = new Thread(myRunnable, "my runnable 1");
        runnableThread.start();
    }

}
