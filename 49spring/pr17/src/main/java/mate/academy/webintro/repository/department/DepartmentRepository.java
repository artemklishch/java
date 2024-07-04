package mate.academy.webintro.repository.department;

import mate.academy.webintro.model.Department;

import java.util.List;

public interface DepartmentRepository {
    List<Department> findAll();

    Department save(Department department);

}
