package org.example;

public class Human implements Eatable, Walkable {
    @java.lang.Override
    public void acceptFood(java.lang.String food) {
        System.out.println("Fooood");
    }

    @java.lang.Override
    public void goWalking() {

    }

    // якщо в обох інтерфейсах є один і той же дефолтний метод - його потрібно переоверрайдити
    @java.lang.Override
    public void printInfo() {
//        Eatable.super.printInfo();
//        Walkable.super.printInfo();
        System.out.println("Custom realization");
    }
}
