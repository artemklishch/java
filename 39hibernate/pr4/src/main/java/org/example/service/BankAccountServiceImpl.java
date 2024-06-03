package org.example.service;

import org.example.dao.BankAccountDao;
import org.example.dao.BankAccountDaoImpl;
import org.example.model.BankAccount;

import java.math.BigDecimal;

public class BankAccountServiceImpl implements BankAccountService{
    private final BankAccountDao bankAccountDao = new BankAccountDaoImpl();

    @Override
    public void transfer(BankAccount from, BankAccount to, BigDecimal amount) {
//        if(from.getAmount().compareTo(amount) < 0) {
//            throw new RuntimeException("Not enough money");
//        }
//        from.setAmount(from.getAmount().subtract(amount));
//        to.setAmount(to.getAmount().add(amount));
//        bankAccountDao.save(from);
//        bankAccountDao.save(to);

    }
}
