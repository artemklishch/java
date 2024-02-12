package model;

public abstract class Animal {
    private String name;
    private boolean isHungry;

    public abstract void eat(Food food);
}
