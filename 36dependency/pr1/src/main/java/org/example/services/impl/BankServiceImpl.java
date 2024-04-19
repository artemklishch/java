package org.example.services.impl;

import org.example.lib.Inject;
import org.example.model.Account;
import org.example.services.AccountService;
import org.example.services.BankService;

import java.math.BigDecimal;
import java.util.Optional;

public class BankServiceImpl implements BankService {
    @Inject
    private AccountService accountService;

    public BankServiceImpl(AccountService accountService) {
        this.accountService = accountService;
    }

    @Override
    public void transfer(String accountForm, String accountTo, BigDecimal amount) {
        Optional<Account> sender = accountService.findByNumber(accountForm);
        Optional<Account> receiver = accountService.findByNumber(accountTo);

        if (sender.isEmpty() || receiver.isEmpty()) {
            throw new RuntimeException("Can't send money from " + accountForm + " to " + accountTo);
        }
        if (sender.get().getBalance() < 0) {
            throw new RuntimeException("Not enough money...");
        }
        //
    }
}
