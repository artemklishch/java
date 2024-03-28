package org.example;

public interface Test {
    void hello();

    default void print() {
        System.out.println("Hello world!");
        hided();
    }

    private void hided() {
        System.out.println("I am private");
    }

    static String get() {
        return "abc";
    }
}
