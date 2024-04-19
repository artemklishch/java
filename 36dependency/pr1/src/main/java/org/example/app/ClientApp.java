package org.example.app;

import org.example.lib.Inject;
import org.example.model.Account;
import org.example.model.User;
import org.example.services.AccountService;
import org.example.services.BankService;

import java.math.BigDecimal;
import java.util.Optional;

public class ClientApp {
    // annotation
    @Inject
    private BankService bankService;
    @Inject
    private AccountService accountService;
    private User currentUser;

    public void sendMoney(String to, BigDecimal amount) {
        Optional<Account> userAccount = accountService.findByUser(currentUser.getName());
        if (userAccount.isEmpty()) {
            throw new RuntimeException("User doe not have an account");
        }
        bankService.transfer(userAccount.get().getAccountNumber(), to, amount);
    }

    public void login(String phoneNumber) {
        this.currentUser = new User("Bob", 23);
    }
}
