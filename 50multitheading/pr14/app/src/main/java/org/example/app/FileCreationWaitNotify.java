package org.example.app;

import java.io.File;
import java.io.IOException;

// correct way
public class FileCreationWaitNotify {
    private static final Object lock = new Object();

    private static volatile boolean isFileCreated = false;

    private static final String FILE_PATH = "file.txt";

    public static void main(String[] args) {
        // start background thread
        Thread fileCreatorThread = new Thread(() -> {
            try {
                Thread.sleep(5000);
                synchronized (lock) {
                    File file = new File(FILE_PATH);
                    if (file.createNewFile()) {
                        System.out.println("File created by background thread");
                        isFileCreated = true;
//                        lock.notifyAll(); // notify the waiting thread
                        lock.notify();
                    }
                }
            } catch (InterruptedException | IOException e) {
                throw new RuntimeException(e);
            }
        });

        fileCreatorThread.start();

        // main thread waiting for the file to be created
        synchronized (lock) {
            while (!isFileCreated) {
                try {
                    lock.wait(); // main thread is waiting here
                    System.out.println("The main method is waiting"); // this is output one time
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }

        // next expressions wait when previous code is executed - firstly - the thread, then the synchronised block that
        // waits with the expression "lock.wait()"
        System.out.println("File creation detected by main thread. Proceeding with process");
        // perform operations on the file

        // cleanup for this example
        new File(FILE_PATH).delete();
        System.out.println("File is deleted");
    }
}
