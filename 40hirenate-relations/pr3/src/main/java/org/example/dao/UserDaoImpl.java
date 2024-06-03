package org.example.dao;

import org.example.model.Order;
import org.hibernate.Session;
import org.example.exceptions.DataProcedingException;
import org.example.model.User;
import org.example.util.HibernateUtil;
import org.hibernate.Transaction;

public class UserDaoImpl implements UserDao{
    @Override
    public User get(Long id) {
        Session session = null;
        try{
            session = HibernateUtil.getSessionFactory().openSession();
            return session.get(User.class, id);
        }catch(Exception e){
            throw new DataProcedingException("Failed to save:" + e);
        }finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public User save(User user) {
        Session session = null;
        Transaction transaction = null;
        try{
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.save(user);
            transaction.commit();
            return user;
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
}
