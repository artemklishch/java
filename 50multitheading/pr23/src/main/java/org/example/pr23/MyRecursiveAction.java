package org.example.pr23;

import java.util.List;
import java.util.concurrent.RecursiveAction;

public class MyRecursiveAction extends RecursiveAction {
    private final long workload;

    private static final int THRESHOLD = 5;

    public MyRecursiveAction(long workload) {
        this.workload = workload;
    }

    @Override
    protected void compute() {
        // if workload is above the threshold, break the task into subtasks
        if (workload > THRESHOLD) {
            System.out.printf(
                    "RecursiveAction: Splitting the task with workload: %s. " + "Thread: %s%n",
                    workload, Thread.currentThread().getName()
            );
            List<RecursiveAction> subtasks = createSubtasks();

            for (RecursiveAction subtask : subtasks) {
                subtask.fork(); // завдяки цьому методу поточне завдання буде виконуватись асинхронно в окремому потоці
            }
        } else {
            System.out.printf(
                    "RecursiveAction: Doing the task with workload: %s. "
                            + "Thread: %s%n", workload, Thread.currentThread().getName()
            );
        }
    }

    private List<RecursiveAction> createSubtasks() {
        RecursiveAction first = new MyRecursiveAction(workload / 2);
        RecursiveAction second = new MyRecursiveAction(workload / 2);
        return List.of(first, second);
    }
}
