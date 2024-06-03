package org.example.dao;

import org.example.exceptions.DataProcedingException;
import org.example.model.Order;
import org.example.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class OrderDaoImpl implements OrderDao {
    @Override
    public Order get(Long id) {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            return session.get(Order.class, id);
        } catch (Exception e) {
            throw new DataProcedingException("Failed to fetch:" + e);
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public Order save(Order order) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.save(order); // managed
            transaction.commit();
            return order;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new DataProcedingException("Failed to save:" + e);
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
}
