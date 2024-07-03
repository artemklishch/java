package mate.academy.webintro.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;

import java.util.List;

import jakarta.persistence.EntityTransaction;
import lombok.RequiredArgsConstructor;
import mate.academy.webintro.model.Employee;
import org.springframework.stereotype.Repository;

@RequiredArgsConstructor // generates constructor
@Repository
public class EmployeeRepositoryImpl implements EmployeeRepository {
    private final EntityManagerFactory entityManagerFactory;

    @Override
    public Employee save(Employee employee) {
        EntityTransaction transaction = null;
        try (EntityManager entityManager = entityManagerFactory.createEntityManager()) {
            transaction = entityManager.getTransaction();
            transaction.begin();
            entityManager.persist(employee);
            transaction.commit();
            return employee;
        } catch (RuntimeException e) {
            if (transaction != null) transaction.rollback();
            throw e;
        }
    }

    @Override
    public List<Employee> findAll() {
        try (EntityManager entityManager = entityManagerFactory.createEntityManager()) {
            return entityManager.createQuery("SELECT e FROM Employee e", Employee.class).getResultList();
        }
    }
}
