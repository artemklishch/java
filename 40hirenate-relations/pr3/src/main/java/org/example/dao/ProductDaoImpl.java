package org.example.dao;

import org.example.exceptions.DataProcedingException;
import org.example.model.Product;
import org.example.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class ProductDaoImpl implements ProductDao{
    @Override
    public Product save(Product product) {
        Session session = null;
        Transaction transaction = null;
        try{
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.save(product);
            transaction.commit();
            return product;
        }catch(Exception e){
            if (transaction != null) {
                transaction.rollback();
            }
            throw new DataProcedingException("Failed to save:" + e);
        }finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public Product get(Long id) {
        Session session = null;
        try{
            session = HibernateUtil.getSessionFactory().openSession();
            return session.get(Product.class, id);
        }catch(Exception e){
            throw new DataProcedingException("Failed to fetch:" + e);
        }finally {
            if (session != null) {
                session.close();
            }
        }
    }
}
