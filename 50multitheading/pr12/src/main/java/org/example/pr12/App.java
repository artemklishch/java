package org.example.pr12;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class App {
    public static void main(String[] args) {
        Thread thread = new MyThread();
        thread.start();
        // start виконується до логіки в методі run thread
    }
}

class MyThread extends Thread {
    @Override
    public void run() {
        System.out.println("Thread is created");
        int sum = 10 + 15;
        System.out.println("The sum is: " +  sum);
    }
}
