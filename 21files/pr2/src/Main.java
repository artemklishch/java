package org.example;

import java.io.File;
import java.io.IOException;
import java.nio.file.StandardOpenOption;
import java.nio.file.Files;
import java.nio.file.Path;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        String[] users = {"Bob", "Alice", "John"};
        File file1 = new File("users.txt");
        try {
            file1.createNewFile();
        } catch (IOException e) {
            throw new RuntimeException("Can't create a file.", e);
        }
        for (String user : users) {
            try {
                Files.write(file1.toPath(), user.getBytes(), StandardOpenOption.APPEND); // StandardOpenOption.APPEND - parameter for appending data to file content
            } catch (IOException e) {
                throw new RuntimeException("Can't write to file", e);
            }
        }

        File file2 = new File("users2.txt");
        Path path = file2.toPath();
        File toFile = path.toFile();
        System.out.println(path);
        System.out.println(toFile);
    }
}