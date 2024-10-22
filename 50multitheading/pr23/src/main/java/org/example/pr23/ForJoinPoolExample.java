package org.example.pr23;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

public class ForJoinPoolExample {
    public static void main(String[] args) throws InterruptedException {
        ForkJoinPool forkJoinPool = ForkJoinPool.commonPool(); // 10 (number of cores in computer processor) - 1 = 9 - 9 threads
        RecursiveAction recursiveAction = new MyRecursiveAction(1000);
        forkJoinPool.invoke(recursiveAction);
        Thread.sleep(1000); // для симуляції роботи, оскільки метод main виконався раніше, ніж логіка в потоках
    }
}
