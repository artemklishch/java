package org.example.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AppApplication {

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new Task());
        thread.start();

        // after some time we need to stop this task
        Thread.sleep(100);
        thread.interrupt();
//        Thread.interrupted();
        System.out.println("Asked politely to stop the task execution");
    }

}
