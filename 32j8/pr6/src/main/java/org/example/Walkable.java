package org.example;

public interface Walkable {
    void goWalking();

    default void printInfo() {
        System.out.println("This is walkable message...");
    }
}
