package org.example.pr8;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Pr8Application {
    public static void main(String[] args) throws InterruptedException {
        VolatileExampleThread exampleThread = new VolatileExampleThread();
        exampleThread.start();
        Thread.sleep(1000L);
        System.out.println("After sleeping main thread");
        exampleThread.setRunning(false);
    }

}
