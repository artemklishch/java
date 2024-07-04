package mate.academy.webintro.repository;

import mate.academy.webintro.dto.EmployeeDto;
import mate.academy.webintro.model.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeRepository {
    Employee save(Employee employee);

    List<Employee> findAll();

    Optional<Employee> findById(Long id);

    List<Employee> findAllByName(String name);
}
