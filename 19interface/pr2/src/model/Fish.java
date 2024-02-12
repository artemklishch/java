package model;

public class Fish extends Animal implements Swimmable {
    private String country;


    @Override
    public void eat(Food food) {
        System.out.println("Fish accepted food");
    }

    @Override
    public void swim() {
        System.out.println("I am swimming");
    }
}
