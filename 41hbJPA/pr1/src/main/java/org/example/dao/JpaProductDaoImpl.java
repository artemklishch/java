package org.example.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import org.example.exceptions.DataProceedingException;
import org.example.model.Product;
import org.example.util.EntityManagerUtil;

public class JpaProductDaoImpl implements ProductDao {
    @Override
    public Product save(Product product) {
        EntityManagerFactory entityManagerFactory = EntityManagerUtil.getEntityManagerFactory();
        EntityManager entityManager = null;
        EntityTransaction transaction = null;
        try {
            entityManager = entityManagerFactory.createEntityManager();
            transaction = entityManager.getTransaction();
            transaction.begin();
            entityManager.persist(product);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new DataProceedingException("Failed to save the product. Error: " + e);
        } finally {
            if (entityManager != null) {
                entityManager.close();
            }
        }
        return product;
    }

    @Override
    public Product get(Long id) {
        return null;
    }

    @Override
    public Product remove(Product product) {
        return null;
    }
}
