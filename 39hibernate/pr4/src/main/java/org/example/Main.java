package org.example;

import org.example.dao.BankAccountDao;
import org.example.dao.BankAccountDaoImpl;
import org.example.model.BankAccount;

import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {
//        MovieDao movieDao = new MovieDaoImpl();
//        Movie movie = new Movie();
//        movie.setTitle("Terminator 5");
//        movie.setDescription("Movi description");
//        movieDao.save(movie);

//        Movie movieFromDB = movieDao.get(1L);
//        System.out.println(movieFromDB);

        BankAccountDao bankAccountDao = new BankAccountDaoImpl();

        BankAccount senderAccount = new BankAccount("Bob", BigDecimal.valueOf(700));
        BankAccount receiverAccount = new BankAccount("Alice", BigDecimal.valueOf(150));
        bankAccountDao.save(senderAccount);
        bankAccountDao.save(receiverAccount);
        bankAccountDao.transfer(senderAccount, receiverAccount, BigDecimal.valueOf(200));
    }
}