package model;

public class User {
    private String name;
    private String phone;

    public User(java.lang.String name, java.lang.String phone) {
        this.name = name;
        this.phone = phone;
    }

    public java.lang.String getName() {
        return name;
    }

    public java.lang.String getPhone() {
        return phone;
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "User{" +
                "name=" + name +
                ", phone=" + phone +
                '}';
    }
}
