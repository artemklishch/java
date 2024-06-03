package org.example.dao;

import org.example.model.BankAccount;
import org.example.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.math.BigDecimal;

public class BankAccountDaoImpl implements BankAccountDao {
    @Override
    public BankAccount save(BankAccount account) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(account);
        transaction.commit();
        session.close();
        return account;
    }

    @Override
    public BankAccount get(Long id) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        return session.get(BankAccount.class, id);
    }

    @Override
    public void transfer(BankAccount senderAccount, BankAccount receiverAccount, BigDecimal amount) {
//        if(senderAccount.getAmount().compareTo(amount) < 0) {
//            throw new RuntimeException("Not enough money");
//        }
//        senderAccount.setAmount(senderAccount.getAmount().subtract(amount));
//        receiverAccount.setAmount(receiverAccount.getAmount().add(amount));
//
//        Session session = HibernateUtil.getSessionFactory().openSession();
//        Transaction transaction = session.beginTransaction();
//        session.update(senderAccount);
//        session.update(receiverAccount);
//        transaction.commit();
//        session.close();

        if (senderAccount.getAmount().compareTo(amount) < 0) {
            throw new RuntimeException("Not enough money");
        }
        senderAccount.setAmount(senderAccount.getAmount().subtract(amount));
        receiverAccount.setAmount(receiverAccount.getAmount().add(amount));

        Session session = null;
        Transaction transaction = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.update(senderAccount);
            if (true) {
                throw new RuntimeException("Error ocured!");
            }
            session.update(receiverAccount);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
}
