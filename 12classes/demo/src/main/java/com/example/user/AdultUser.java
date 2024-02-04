package com.example.user;

public class AdultUser {
    private String name;
    private int age;

    public int getAge() {
        return age;
    }

    public void setAge(int value) {
        if (value < 18) {
            System.out.println("Age is less tne expected");
        } else {
            this.age = value;
        }
    }

    public String getString() {
        return name;
    }

    public void setName(String value) {
        this.name = value;
    }
}
