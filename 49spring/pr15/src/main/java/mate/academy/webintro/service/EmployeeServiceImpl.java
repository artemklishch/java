package mate.academy.webintro.service;

import lombok.RequiredArgsConstructor;
import mate.academy.webintro.dto.CreateEmployeeRequestDto;
import mate.academy.webintro.dto.EmployeeDto;
import mate.academy.webintro.exception.EntityNotFountException;
import mate.academy.webintro.mapper.EmployeeMapper;
import mate.academy.webintro.model.Employee;
import mate.academy.webintro.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Random;

@RequiredArgsConstructor
@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final EmployeeMapper employeeMapper;

    @Override
    public EmployeeDto save(CreateEmployeeRequestDto requestDto) {
        Employee employee = employeeMapper.toModel(requestDto);
        employee.setSocialSecurityNumber("abc " + new Random().nextInt(1000));
        return employeeMapper.toDto(employeeRepository.save(employee));
    }

    @Override
    public List<EmployeeDto> findAll() {
        return employeeRepository.findAll().stream()
                .map(employeeMapper::toDto)
                .toList();
    }

    @Override
    public EmployeeDto findById(Long id) {
//        Optional<Employee> optionalEmployee = employeeRepository.findById(id);
//        if (optionalEmployee.isPresent()) {
//            return employeeMapper.toDto(optionalEmployee.get());
//        }
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new EntityNotFountException(
                        "Can't find employee with id: " + id)
                );
        return employeeMapper.toDto(employee);
    }

    @Override
    public List<EmployeeDto> findAllByName(String name) {
        return employeeRepository.findAllByName(name).stream()
                .map(employeeMapper::toDto)
                .toList();
    }
}
