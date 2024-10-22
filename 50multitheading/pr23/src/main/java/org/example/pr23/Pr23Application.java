package org.example.pr23;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.concurrent.ForkJoinPool;

@SpringBootApplication
public class Pr23Application {

    public static void main(String[] args) {
//        ForkJoinPool forkJoinPool = ForkJoinPool.commonPool();
//        int[] numbers = {14, 8, 20, 5, 33, 12, 26, 70, 1};
//        MaxElementTask maxElementTask = new MaxElementTask(numbers);
//        Integer maxElement = forkJoinPool.invoke(maxElementTask);
//        System.out.println("Max element is: " + maxElement);

        int[] numbers = {14, 8, 20, 5, 33, 12, 26, 70, 1};
        MaxElementTask maxElementTask = new MaxElementTask(numbers);
        int result = maxElementTask.invoke(); // This will start the Fork-Join task
        System.out.println("Max value is: " + result);
        // в цьому випадку частину завдань виконує метод main
    }

}
