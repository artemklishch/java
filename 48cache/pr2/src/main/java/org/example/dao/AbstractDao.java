package org.example.dao;

import org.hibernate.SessionFactory;

public class AbstractDao {
    protected SessionFactory factory;

    public AbstractDao(SessionFactory sessionFactory) {
        this.factory = sessionFactory;
    }
}
