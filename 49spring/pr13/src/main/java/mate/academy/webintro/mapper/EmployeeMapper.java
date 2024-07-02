package mate.academy.webintro.mapper;

import mate.academy.webintro.dto.CreateEmployeeRequestDto;
import mate.academy.webintro.dto.EmployeeDto;
import mate.academy.webintro.model.Employee;

public interface EmployeeMapper {
    EmployeeDto toDto(Employee employee);

    Employee toModel(CreateEmployeeRequestDto requestDto);
}
