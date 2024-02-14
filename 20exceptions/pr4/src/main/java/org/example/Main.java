package org.example;

import java.io.BufferedReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.IOException;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        String fileName = "cities.txt";
//        BufferedReader reader = null;
//        try {
//            reader = Files.newBufferedReader(Paths.get(fileName));
//            System.out.println("Everything was ok");
//        } catch (IOException e) {
//            System.out.println("Can't read file with name " + fileName);
//        } finally {
//            try {
//                if (reader != null) {
//                    reader.close();
//                }
//            } catch (IOException err) {
//                er.printStackrace();
//            }
//        }

        try (BufferedReader newReader = Files.newBufferedReader(Paths.get(fileName))) {
            System.out.println("Everything was ok");
        } catch (IOException e) {
            System.out.println("Can't read file with name " + fileName);
        }
    }
}