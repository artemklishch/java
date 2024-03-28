package org.example;

public class TestMain {
    public static void main(String[] args) {
//        Test test = new TestImpl();
//        Test test = new Test() {
//            @java.lang.Override
//            public void print(java.lang.String value) {
//                System.out.println(value);
//            }
//        };
        Test test = value -> System.out.println(value);
        Test test2 = (value) -> System.out.println(value);
        test2.print("Hello!");
    }
}
