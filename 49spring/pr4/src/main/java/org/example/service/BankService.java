package org.example.service;

import org.example.model.User;

import java.math.BigDecimal;

public interface BankService {
    void pay(int serviceId, BigDecimal amount, User user);
}
