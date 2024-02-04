package com.example;

import com.example.model.Dog;

public class PublicMain {
    public static void main(String[] args) {
        Dog dog = new Dog();
        dog.tailLength = 14;
        dog.name = "some name";
        dog.age = 3;
        // dog.owner = "sadf";
        boolean isDogHasOwner = dog.hasOwner();
        System.out.println("isDogHasOwner " + isDogHasOwner);
        dog.setOwner("Bob");
        isDogHasOwner = dog.hasOwner();
        System.out.println("isDogHasOwner " + isDogHasOwner);
    }
}
