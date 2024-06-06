package org.example.util;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class EntityManagerUtil {
    private static final EntityManagerFactory instance = initEntityManagerFactory();

    public static EntityManagerFactory getEntityManagerFactory(){
        return instance;
    }

    private static EntityManagerFactory initEntityManagerFactory(){
        return Persistence.createEntityManagerFactory("mate.academy.ticket_app");
    }
}
