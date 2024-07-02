package mate.academy.webintro.repository;

import mate.academy.webintro.model.Employee;

import java.util.List;

public interface EmployeeRepository {
    Employee save(Employee employee);

    List<Employee> findAll();
}
