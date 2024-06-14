package org.example.dao.impl;

import org.example.dao.AddressDao;
import org.example.model.Address;
import org.example.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class AddressDaoImpl implements AddressDao {
    @Override
    public Address save(Address address) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.merge(address);
            transaction.commit();
            return address;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new RuntimeException("Failed to save address: " + address + ". Error: " + e);
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
}
