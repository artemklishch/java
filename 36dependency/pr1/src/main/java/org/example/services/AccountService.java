package org.example.services;

import org.example.model.Account;

import java.util.Optional;

public interface AccountService {
    Optional<Account> findByNumber(String accountNumber);

    Optional<Account> findByUser(String userName);
}
