package org.example.pr23;

import java.util.concurrent.RecursiveTask;

public class MaxElementTask extends RecursiveTask<Integer> {
    private final int[] array;

    private final int start;

    private final int end;

    //    private static final int THRESHOLD = 4;
    private static final int THRESHOLD = 3;

    public MaxElementTask(int[] array) {
        this(array, 0, array.length - 1);
    }

    public MaxElementTask(int[] array, int start, int end) {
        this.array = array;
        this.start = start;
        this.end = end;
    }

    @Override
    protected Integer compute() {
        if (end - start <= THRESHOLD) {
            System.out.printf(
                    "RecursiveTask: Doing the task where start = %s, and end = %s. "
                            + "Thread: %s%n", start, end, Thread.currentThread().getName()
            );
            return findMax(array, start, end);
        } else {
            System.out.printf(
                    "RecursiveTask: Splitting the task where start = %s, and end = %s. "
                            + "Thread: %s%n", start, end, Thread.currentThread().getName()
            );

            // Split the task
            int middle = start + (end - start) / 2;
            MaxElementTask left = new MaxElementTask(array, start, middle);
            MaxElementTask right = new MaxElementTask(array, middle, end);

//            left.fork();
//            right.fork();
//            int rightResult = right.join(); // wait for the right task and get its result
//            int leftResult = left.join(); // wait for the left task and get its result

            left.fork();
            int rightResult = right.compute(); // compute the right side; в цьому прикладі ми не зпускаємо праву чатсину
            // в окремому потоці, а виконуємо її логіку в поточноу потоці
            int leftResult = left.join(); // wait for the left task and get its result

            return Math.max(leftResult, rightResult);
        }
    }

    private int findMax(int[] array, int start, int end) {
        int max = array[start];
        for (int i = start; i <= end; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }
        return max;
    }
}

// якщо є великий пул потоків, то доцільно обирати метод compute()
