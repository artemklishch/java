package org.example.app;

import org.example.lib.Inject;
import org.example.services.BankService;

import java.math.BigDecimal;

public class BankOperatorApp {
    @Inject
    private BankService bankService;

    public void sendMoney(String from, String to, BigDecimal amount) {
        bankService.transfer(from, to, amount);
    }
}
