package org.example.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.File;
import java.io.IOException;

// incorrect way
@SpringBootApplication
public class AppApplication {
    private static final String FILE_PATH = "file.txt";

    public static void main(String[] args) {
        Thread fileCreatorThread = new Thread(() -> {
            try {
                Thread.sleep(5000);// simulate work
                File file = new File(FILE_PATH);
                if (file.createNewFile()) {
                    System.out.println("File created bt background thread");
                }
            } catch (InterruptedException | IOException e) {
                throw new RuntimeException(e);
            }
        });

        fileCreatorThread.start();

        // busy waiting for the file to be created
        while (!new File(FILE_PATH).exists()) {
            // inefficient use of CPU
            System.out.println("The main thread is waiting");
        }

        System.out.println("File detected by main thread. Proceeding with processing");
        // perform operation on the file

        // cleanup for thei example
        new File(FILE_PATH).delete();
        System.out.println("File is deleted");
    }

}
