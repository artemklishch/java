package org.example.dao.impl;

import org.example.dao.AbstractDao;
import org.example.dao.AuthorDao;
import org.example.model.Author;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class AuthorDaoImpl extends AbstractDao implements AuthorDao {
    public AuthorDaoImpl(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    @Override
    public Author save(Author author) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = factory.openSession();
            transaction = session.beginTransaction();
            session.persist(author);
            transaction.commit();
            return author;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new RuntimeException(
                    "Failed to save the product: " + author + ". Error: " + e
            );
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public Author get(Long id) {
        try (Session session = factory.openSession()) {
            return session.get(Author.class, id);
        } catch (Exception e) {
            throw new RuntimeException("failed to fetch author by id: " + id + ". Error: " + e);
        }
    }
}
