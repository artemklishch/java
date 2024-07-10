package mate.academy.webintro.service;

import mate.academy.webintro.dto.CreateEmployeeRequestDto;
import mate.academy.webintro.dto.EmployeeDto;

import java.util.List;

public interface EmployeeService {
    EmployeeDto save(CreateEmployeeRequestDto requestDto);

    List<EmployeeDto> findAll();

    EmployeeDto findById(Long id);

    List<EmployeeDto> findAllByName(String name);

    void deleteById(Long id);
}
