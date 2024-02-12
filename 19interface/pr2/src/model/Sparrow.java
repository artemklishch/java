package model;

public class Sparrow extends Bird implements Flyable {

    @java.lang.Override
    public void fly() {
        System.out.println("I am flying");
    }
}
