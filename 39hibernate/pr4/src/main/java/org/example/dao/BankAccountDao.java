package org.example.dao;

import org.example.model.BankAccount;

import java.math.BigDecimal;

public interface BankAccountDao {
    BankAccount save(BankAccount account);

    BankAccount get(Long id);

    void transfer(BankAccount senderAccount, BankAccount receiverAccount, BigDecimal amount);
}
