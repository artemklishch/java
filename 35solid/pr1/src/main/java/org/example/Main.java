package org.example;

import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {
        // SOLID
        // SRP - single responsibility
        // OCP - open closed
        // LSP - Liskov Substitution
        // ISP - Interface Segregation
        // DI - Dependency Inversion

        BankService bankService = new BankServiceImpl();
        bankService.transfer("1233", "5766", BigDecimal.valueOf(10));
    }
}