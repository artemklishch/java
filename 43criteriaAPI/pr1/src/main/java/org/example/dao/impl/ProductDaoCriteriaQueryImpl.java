package org.example.dao.impl;

import jakarta.persistence.criteria.*;
import org.example.dao.ProductDao;
import org.example.model.Product;
import org.example.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.criteria.HibernateCriteriaBuilder;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;

public class ProductDaoCriteriaQueryImpl implements ProductDao {
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
    public List<Product> findAllWherePriceBetween(BigDecimal from, BigDecimal to) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery<Product> query = cb.createQuery(Product.class);
            Root<Product> productRoot = query.from(Product.class);
            Predicate priceGt = cb.gt(productRoot.get("price"), from);
            Predicate priceLt = cb.lt(productRoot.get("price"), to);
            // select form products price > from && price < to
            Predicate pricePredicate = cb.and(priceGt, priceLt);
            query.where(pricePredicate);
            return session.createQuery(query).getResultList();
        } catch (Exception e) {
            throw new RuntimeException(
                    "Failed to fetch the products"
            );
        }
    }

    @Override
    public List<Product> findAllWherePriceBetweenAndColorIn(BigDecimal from, BigDecimal to, String[] colors) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery<Product> query = cb.createQuery(Product.class);
            Root<Product> productRoot = query.from(Product.class);
            Predicate priceGt = cb.gt(productRoot.get("price"), from);
            Predicate priceLt = cb.lt(productRoot.get("price"), to);
            Predicate pricePredicate = cb.and(priceGt, priceLt);

            // where price > from and price < to and color in (red, black, white)
            CriteriaBuilder.In<String> colorPredicate = cb.in(productRoot.get("color"));
            for (String color : colors) {
                colorPredicate.value(color);
            }
            query.where(cb.and(pricePredicate, colorPredicate));
            return session.createQuery(query).getResultList();
        } catch (Exception e) {
            throw new RuntimeException(
                    "Failed to fetch the products"
            );
        }
    }

    @Override
    public List<Product> findAllWherePriceBetweenOrColorIn(BigDecimal from, BigDecimal to, String[] colors) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery<Product> query = cb.createQuery(Product.class);
            Root<Product> productRoot = query.from(Product.class);
            Predicate priceGt = cb.gt(productRoot.get("price"), from);
            Predicate priceLt = cb.lt(productRoot.get("price"), to);
            Predicate pricePredicate = cb.and(priceGt, priceLt);

            // where price > from and price < to or color in (red, black, white)
            CriteriaBuilder.In<String> colorPredicate = cb.in(productRoot.get("color"));
            for (String color : colors) {
                colorPredicate.value(color);
            }
            query.where(cb.or(pricePredicate, colorPredicate));
            return session.createQuery(query).getResultList();
        } catch (Exception e) {
            throw new RuntimeException(
                    "Failed to fetch the products"
            );
        }
    }
}
