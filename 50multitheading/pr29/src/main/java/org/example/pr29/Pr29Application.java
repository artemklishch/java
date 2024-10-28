package org.example.pr29;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.concurrent.ConcurrentLinkedQueue;

@SpringBootApplication
public class Pr29Application {

    public static void main(String[] args) throws InterruptedException {
        ConcurrentLinkedQueue<String> queue = new ConcurrentLinkedQueue<>();

        Thread producer = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                queue.offer("Message " + i);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        Thread consumer = new Thread(() -> {
            while (true) { // тут виникає busy waiting; можна вирішити через використання змінної з булевим значенням
                // наприклад, перевіряти чи пуста черга, можна використати ключове слово volatile
                String message = queue.poll();
                if (message != null) {
                    System.out.println("Consumed: " + message);
                }
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        producer.start();
        consumer.start();

        producer.join();
        consumer.join();
    }

}
