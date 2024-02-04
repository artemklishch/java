package com.example.model;

public class PublicMain1 {
    public static void main(String[] args) {
        Dog1 dog = new Dog1();
        dog.tailLength = 14;
        dog.name = "some name";
        dog.age = 3; // here we have all access because all classes are in one package
    }
}
