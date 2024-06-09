package org.example.dao.impl;

import org.example.dao.ProductDao;
import org.example.model.Product;
import org.example.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;

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
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new RuntimeException(
                    "Failed to save the product. Error: " + e
            );
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return null;
    }

    @Override
    public Product get(Long id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.get(Product.class, id);
        } catch (Exception e) {
            throw new RuntimeException(
                    "Failed to fetch the product by id: " + id
            );
        }
    }

    @Override
    public List<Product> findAll() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query<Product> getAllProductsQuery = session.createQuery("from Product", Product.class);
//            Query<Product> getAllProductsQuery = session.createQuery("from p from Product", Product.class);
            return getAllProductsQuery.getResultList();
        } catch (Exception e) {
            throw new RuntimeException("Failed to fetch products");
        }
    }

    @Override
    public List<Product> findAllPriceGrater(BigDecimal price) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query<Product> getAllProductsQuery = session.createQuery(
                    "from Product p where p.price > :value", Product.class // we use the name of field - 'price'
            );
            return getAllProductsQuery.setParameter("value", price).getResultList();
        } catch (Exception e) {
            throw new RuntimeException("Failed to fetch products");
        }
    }
}
