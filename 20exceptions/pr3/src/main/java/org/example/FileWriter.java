package org.example;

import java.io.BufferedWriter;
import java.io.IOException;

public class FileWriter {
    public void write(String destinationFile, String content) {
        BufferedWriter writer = null;
        try {
            writer = new BufferedWriter(new java.io.FileWriter(destinationFile));
            writer.write(content.toLowerCase());
            if (true) {
                throw new IOException("Test error");
            }
            writer.write(content.toUpperCase());
        } catch (IOException error) {
//            error.printStackTrace();
            throw new RuntimeException("Can't write to file " + destinationFile, error);
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    throw new RuntimeException("Can't close resource", e);
                }
            }
        }
    }
}
