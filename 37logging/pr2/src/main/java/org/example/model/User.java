package org.example.model;

public class User {
    private String login;

    private String password;

    public User(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public String getPassword() {
        return password;
    }
}
