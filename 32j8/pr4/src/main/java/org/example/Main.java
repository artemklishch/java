package org.example;

public class Main {
    public static void main(String[] args) {
        Test test = new Test() {
//            @java.lang.Override
//            public void say(java.lang.String value) {
//                System.out.println(value);
//            }

            @java.lang.Override
            public void print(java.lang.String value) {
                System.out.println(value);
            }
        };

        Test test2 = value -> System.out.println(value);
        test2.print("Hello");
    }
}