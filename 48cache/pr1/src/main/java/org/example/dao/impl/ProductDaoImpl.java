package org.example.dao.impl;

import org.example.dao.ProductDao;
import org.example.model.Product;
import org.example.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class ProductDaoImpl implements ProductDao {
    @Override
    public Product save(Product product) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.persist(product);
            transaction.commit();
            return product;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new RuntimeException(
                    "Failed to save the product: " + product + ". Error: " + e
            );
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public Product get(Long id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
//            Product product = session.get(Product.class, id);
//            Product anotherProduct = session.get(Product.class, id);
//            return product;
            return session.get(Product.class, id);
        } catch (Exception e) {
            throw new RuntimeException("failed to fetch product by id: " + id + ". Error: " + e);
        }
    }
}
