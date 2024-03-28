package org.example;

public class User {
    private String name;

    public User(java.lang.String name) {
        this.name = name;
    }

    public java.lang.String getName() {
        return name;
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "User{" +
                "name=" + name +
                '}';
    }
}
