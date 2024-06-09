package org.example.dao.impl;

import org.example.dao.ReviewDao;
import org.example.model.Product;
import org.example.model.Review;
import org.example.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class ReviewDaoImpl implements ReviewDao {
    @Override
    public Review save(Review review) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.persist(review);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new RuntimeException(
                    "Failed to save the review. Error: " + e
            );
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return null;
    }

    @Override
    public Review get(Long id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.get(Review.class, id);
        } catch (Exception e) {
            throw new RuntimeException(
                    "Failed to fetch the product by id: " + id
            );
        }
    }
}
