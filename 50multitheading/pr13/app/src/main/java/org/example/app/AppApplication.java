package org.example.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AppApplication {

    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter();
        Thread t1 = new CounterIncrementer(counter, "Incrementer #1");
        Thread t2 = new CounterIncrementer(counter, "Incrementer #2");

        Thread t3 = new SecondCounterIncrementer(counter, "Incrementer #3");
        Thread t4 = new SecondCounterIncrementer(counter, "Incrementer #4");

        t1.start();
        t2.start();
        t3.start();
        t4.start();

        t1.join();
        t2.join();
        t3.join();
        t4.join();

        System.out.println("Done: " + counter.getValue());
        System.out.println("Done: " + counter.getValue2());
    }

}
