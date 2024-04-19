package org.example.model;

import java.math.BigDecimal;

public class Account {
    private int balance;
    private String accountNumber;
    private User user;

    public Account(String accountNumber, User user) {
        this.accountNumber = accountNumber;
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public int getBalance() {
        return balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }
}
