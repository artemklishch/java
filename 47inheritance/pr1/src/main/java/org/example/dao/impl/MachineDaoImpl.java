package org.example.dao.impl;

import org.example.dao.MachineDao;
import org.example.model.Machine;
import org.example.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class MachineDaoImpl implements MachineDao {
    @Override
    public Machine save(Machine machine) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.persist(machine);
            transaction.commit();
            return machine;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new RuntimeException(
                    "Failed to save the machine. Error: " + e
            );
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
}
