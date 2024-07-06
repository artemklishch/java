package mate.academy.webintro.service.employee;

import mate.academy.webintro.dto.employee.CreateEmployeeRequestDto;
import mate.academy.webintro.dto.employee.EmployeeDto;
import mate.academy.webintro.dto.employee.EmployeeWithoutSkillsDto;

import java.util.List;

public interface EmployeeService {
    EmployeeDto save(CreateEmployeeRequestDto requestDto);

    //    List<EmployeeDto> findAll();
    List<EmployeeWithoutSkillsDto> findAll();

    EmployeeDto findById(Long id);

    List<EmployeeDto> findAllByName(String name);
}
