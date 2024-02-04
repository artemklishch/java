package com.example;

public class Main {
    public static void main(String[] args) {
        // Car car = new Car(2020, "red");
        Car car = new Car();
        Machine machine1 = new Machine();
        Machine machine2 = new Car();
        Object machine3 = new Car();
        Object machine4 = new Machine();

        // String str = new Car(); // not working
        Object str = new String();

        System.out.println("Hello world! " + car.toString());
    }
}