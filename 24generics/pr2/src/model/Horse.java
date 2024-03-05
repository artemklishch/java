package model;

public class Horse extends Animal implements Cloneable{
    private String name;

    public Horse(String name) {
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}