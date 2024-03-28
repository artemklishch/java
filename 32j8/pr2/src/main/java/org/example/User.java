package org.example;

public class User {
    private String name;
    private int age;

    public User(java.lang.String name, int age) {
        this.name = name;
        this.age = age;
    }

    public java.lang.String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "User{" +
                "name=" + name +
                ", age=" + age +
                '}';
    }
}
