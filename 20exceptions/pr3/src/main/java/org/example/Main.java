package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        try {
            System.out.println("Try block");
            int res = 5 / 0;
            System.out.println("Try code completed");
        } catch (Exception error) {
            System.out.println("Catch block");
        } finally {
            System.out.println("Finally block");
        }
    }
}