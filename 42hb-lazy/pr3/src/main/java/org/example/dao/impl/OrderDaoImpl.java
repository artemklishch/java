package org.example.dao.impl;

import org.example.dao.OrderDao;
import org.example.model.Order;
import org.example.model.Product;
import org.example.model.User;
import org.example.util.HibernateUtil;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.Collections;
import java.util.List;

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
            Query<Order> getOrderQuery = session.createQuery(
                    "from Order o "
                            + " left join fetch o.products where o.id = :id",
                    Order.class
            );
            getOrderQuery.setParameter("id", id);
            return getOrderQuery.getSingleResult();
        } catch (Exception e) {
            throw new RuntimeException(
                    "Failed to fetch the order by id: " + id
            );
        }
    }

    @Override
    public List<Order> findAll(User user) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query<Order> getOrderQuery = session.createQuery(
                    "from Order o "
                            + " left join fetch o.products where o.owner = :owner",
                    // " join fetch o.products where o.owner = :owner" якщо вказати без left - то не будуть отримуватись замовлення, в яких немає продуктів
                    Order.class
            );
            getOrderQuery.setParameter("owner", user);
            return getOrderQuery.getResultList();
        } catch (Exception e) {
            throw new RuntimeException(
                    "Failed to fetch the orders"
            );
        }
    }
}
