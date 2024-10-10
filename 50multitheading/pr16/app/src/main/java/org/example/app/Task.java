package org.example.app;

public class Task implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 100000000; i++) {
            processDataChunk(i);

            // check if the thread has been interrupted
            if (Thread.currentThread().isInterrupted()) {
                System.out.println("Sata processing was interrupted. Stopping.");
                break;
            }
        }
    }

    private void processDataChunk(int chunk) {
        // simulate a time-consuming task
        try {
            Thread.sleep(1);
            System.out.println("Process chunkL " + chunk);
        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
            Thread.currentThread().interrupt();
            return;
        }
        System.out.println("Some other actions");
    }
}
