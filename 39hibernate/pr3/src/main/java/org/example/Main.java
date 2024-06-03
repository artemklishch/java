package org.example;

import org.example.model.Movie;
import org.example.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class Main {
    public static void main(String[] args) {
        // ORM - object relational mapping
        // 1. Create Movie class
        // 2. Add required dependencies
        // 3. Add Hibernate configuration
        // 4. Save movie to DB

        // main interfaces to work with, when work with Hibernate
        // SessionFactory object
        // Session object
        // Transaction object

        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Movie movie = new Movie();
        movie.setTitle("Terminator 5");
        movie.setDescription("Movi description");
        session.save(movie);
        transaction.commit();
        session.close();
    }
}