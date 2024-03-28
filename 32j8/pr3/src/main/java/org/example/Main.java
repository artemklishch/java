package org.example;

public class Main {
    public static void main(String[] args) {
        // Lambda

        NoElements noElements = () -> System.out.println("Hello");
//        SingleElement singleElement = s -> System.out.println(s);
        SingleElement singleElement = s -> {
            if (s == null) {
                System.out.println("Null value");
            }
            System.out.println(s);
        };
        TwoElements twoElements = (a, b) -> a - b;
    }
}