package org.example.service;

import org.example.model.BankAccount;

import java.math.BigDecimal;

public interface BankAccountService {
    void transfer(BankAccount from, BankAccount to, BigDecimal amount);
}
