package org.example.dao.impl;

import org.example.dao.OrderDao;
import org.example.model.Order;
import org.example.model.Product;
import org.example.util.HibernateUtil;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class OrderDaoImpl implements OrderDao {
    @Override
    public Order save(Order order) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.persist(order);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new RuntimeException(
                    "Failed to save the order. Error: " + e
            );
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return null;
    }

    @Override
    public Order get(Long id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
//            Order order = session.get(Order.class, id);
////            System.out.println("received order"); // this is a hack
////            order.getProducts().size();
//            return order;

//            Order order = session.get(Order.class, id);
//            Hibernate.initialize(order.getProducts());
//            return order;

            Order order = session.get(Order.class, id);
            Hibernate.initialize(order.getProducts());
            return order;
        } catch (Exception e) {
            throw new RuntimeException(
                    "Failed to fetch the order by id: " + id
            );
        }
    }
}
