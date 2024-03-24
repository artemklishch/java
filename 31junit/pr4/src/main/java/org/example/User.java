package org.example;

public class User {
    private final String name;
    private final int age;

    public User(java.lang.String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
//        if (!super.equals(object)) return false; // not working with it
        User user = (User) object;
        return age == user.age && java.util.Objects.equals(name, user.name);
    }

    public int hashCode() {
        return java.util.Objects.hash(super.hashCode(), name, age);
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "User{" +
                "name=" + name +
                ", age=" + age +
                '}';
    }
}