package org.example.pr20;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.concurrent.Semaphore;

@SpringBootApplication
public class Pr20Application {
    private static final int NUM_PHILOSOPHERS = 5;

    public static void main(String[] args) {
//        Philosopher[] philosophers = new Philosopher[NUM_PHILOSOPHERS];
//        Object[] forks = new Object[NUM_PHILOSOPHERS];
//
//        for (int i = 0; i < NUM_PHILOSOPHERS; i++) {
//            forks[i] = new Object();
//        }
//        for (int i = 0; i < NUM_PHILOSOPHERS; i++) {
//            Object leftFork = forks[i];
//            Object rightFork = forks[(i + 1) % NUM_PHILOSOPHERS];
//
//            philosophers[i] = new Philosopher(leftFork, rightFork);
//
//            Thread t = new Thread(philosophers[i], "Philosopher " + (i + 1));
//            t.start();
//        }


        Semaphore semaphore = new Semaphore(2); // дозволяємо два потоки

        for (int i = 0; i < NUM_PHILOSOPHERS; i++) {
            Runnable philosopher = new Philosopher(semaphore);
            Thread t = new Thread(philosopher, "Philosopher " + (i + 1));
            t.start();
        }
    }

}
