package org.example;

import org.example.db.Storage;
import org.example.model.Account;

import java.math.BigDecimal;

public class BankServiceImpl implements BankService {
    @Override
    public void transfer(String fromAccountNumber, String toAccountNumber, BigDecimal amount) {
        Account fromAccount = get(fromAccountNumber);
        Account toAccount = get(toAccountNumber);
        BigDecimal newValueFrom = fromAccount.getAmount().subtract(amount);
        fromAccount.setAmount(newValueFrom);

        BigDecimal newValueTo = toAccount.getAmount().add(amount);
        toAccount.setAmount(newValueTo);
    }

    public void add(String accountNumber) {
        Account account = new Account();
        account.setAccount(accountNumber);
        Storage.accounts.add(account);
    }

    public Account get(String accountNumber) {
        return Storage.accounts.stream()
                .filter(a -> a.getAccount().equals(accountNumber)).findFirst().get();
    }
}
