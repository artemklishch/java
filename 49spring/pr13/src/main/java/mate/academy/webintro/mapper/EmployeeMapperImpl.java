package mate.academy.webintro.mapper;

import mate.academy.webintro.dto.CreateEmployeeRequestDto;
import mate.academy.webintro.dto.EmployeeDto;
import mate.academy.webintro.model.Employee;
import org.springframework.stereotype.Component;

@Component
public class EmployeeMapperImpl implements EmployeeMapper{
    @Override
    public Employee toModel(CreateEmployeeRequestDto requestDto) {
        Employee employee = new Employee();
        employee.setEmail(requestDto.getEmail());
        employee.setName(requestDto.getName());
        return employee;
    }

    @Override
    public EmployeeDto toDto(Employee employee) {
        EmployeeDto dto = new EmployeeDto();
        dto.setId(employee.getId());
        dto.setName(employee.getName());
        dto.setEmail(employee.getEmail());
        return dto;
    }
}
