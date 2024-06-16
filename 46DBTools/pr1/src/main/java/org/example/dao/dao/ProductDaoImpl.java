package org.example.dao.dao;

import org.example.dao.ProductDao;
import org.example.model.Product;
import org.example.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class ProductDaoImpl implements ProductDao {
    @Override
    public List<Product> findAll() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query<Product> getOrderQuery = session.createQuery(
                    "from Product",
                    Product.class
            );
            return getOrderQuery.getResultList();
        } catch (Exception e) {
            throw new RuntimeException(
                    "Failed to fetch the products"
            );
        }
    }

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
            throw new RuntimeException("Failed to save user: " + product + ". Error: " + e);
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public Product get(Long id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.get(Product.class, id);
        } catch (Exception e) {
            throw new RuntimeException("failed to fetch product by id: " + id + ". Error: " + e);
        }
    }
}
