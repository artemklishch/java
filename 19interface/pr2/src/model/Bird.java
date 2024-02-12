package model;

public class Bird extends Animal {
    private String featherColor;


    @Override
    public void eat(Food food) {
        System.out.println("Bird accepted food");
    }
}
