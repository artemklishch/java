package org.example.services;

import java.math.BigDecimal;

public interface BankService {
    void transfer(String accountForm, String accountTo, BigDecimal amount);
}
