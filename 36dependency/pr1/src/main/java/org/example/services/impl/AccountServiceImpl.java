package org.example.services.impl;

import org.example.model.Account;
import org.example.model.User;
import org.example.services.AccountService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class AccountServiceImpl implements AccountService {
    private static final List<Account> accounts = new ArrayList<>();

    // способи реалзіації
    // classes where we can pass different services
    // setters via which we can assign different services
    // field injection, java reflection API

    static {
        User bob = new User("Bob", 23);
        User alice = new User("Alice", 19);

        Account bobAccount = new Account("1234", bob);
        Account aliceAccount = new Account("5678", alice);

        accounts.add(bobAccount);
        accounts.add(aliceAccount);
    }

    @Override
    public Optional<Account> findByNumber(String accountNumber) {
        return accounts.stream().filter(u -> u.getAccountNumber().equals(accountNumber)).findFirst();
    }

    @Override
    public Optional<Account> findByUser(String userName) {
//        return accounts.stream().filter(u -> u.getOwner().getName().equals(userName)).findFirst();
        return null;
    }
}
