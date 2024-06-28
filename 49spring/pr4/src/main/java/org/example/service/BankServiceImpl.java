package org.example.service;

import org.example.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class BankServiceImpl implements BankService {
    @Autowired
    @Qualifier("goldCommissionHandler") // when no default realization and all realizations are the same we can use this way
    private CommissionHandler commissionHandler;

    @Override
    public void pay(int serviceId, BigDecimal amount, User user) {
        commissionHandler.getCommission(amount);
    }
}

