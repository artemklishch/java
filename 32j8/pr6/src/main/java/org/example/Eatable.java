package org.example;

public interface Eatable {
    void acceptFood(String food);

    default void printInfo() {
        System.out.println("This is eatable message...");
    }
}
