package model;

public class Pinguin extends Bird implements Swimmable {
    @Override
    public void swim() {
        System.out.println("I am swimming");
    }
}
