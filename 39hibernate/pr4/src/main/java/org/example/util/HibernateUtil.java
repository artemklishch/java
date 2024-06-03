package org.example.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
    private static SessionFactory instance = initSessionFactory();

    private static SessionFactory initSessionFactory() {
        return new Configuration().configure().buildSessionFactory();
        // under the hood this class finds by itself the Hibernate configurating file
    }

    public static SessionFactory getSessionFactory() {
        return instance;
    }
}
