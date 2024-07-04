//package mate.academy.webintro.mapper;
//
//import mate.academy.webintro.dto.CreateEmployeeRequestDto;
//import mate.academy.webintro.dto.EmployeeDto;
//import mate.academy.webintro.model.Department;
//import mate.academy.webintro.model.Employee;
//import org.springframework.stereotype.Component;
//
//@Component
//public class EmployeeMapperImpl implements EmployeeMapper {
//    @Override
//    public EmployeeDto toDto(Employee employee) {
//        if (employee == null) {
//            return null;
//        }
//        EmployeeDto employeeDto = new EmployeeDto();
//        employeeDto.setId(employee.getId());
//        employeeDto.setName(employee.getName());
//        employeeDto.setEmail(employee.getEmail());
//        return employeeDto;
//    }
//
//    @Override
//    public Employee toModel(CreateEmployeeRequestDto requestDto) {
//        if (requestDto == null) {
//            return null;
//        }
//        Employee employee = new Employee();
//        employee.setName(requestDto.name());
//        employee.setEmail(requestDto.email());
//        employee.setDepartment(new Department(requestDto.departmentId())); // it is enough
//        return employee;
//    }
//}

package mate.academy.webintro.mapper;

import mate.academy.webintro.dto.CreateEmployeeRequestDto;
import mate.academy.webintro.dto.EmployeeDto;
import mate.academy.webintro.model.Department;
import mate.academy.webintro.model.Employee;
import org.springframework.stereotype.Component;

//@Component
public class EmployeeMapperImpl implements EmployeeMapper {
    private final DepartmentMapper departmentMapper;

    public EmployeeMapperImpl(DepartmentMapper departmentMapper) {
        this.departmentMapper = departmentMapper;
    }

    @Override
    public EmployeeDto toDto(Employee employee) {
        if (employee == null) {
            return null;
        }
        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setId(employee.getId());
        employeeDto.setName(employee.getName());
        employeeDto.setEmail(employee.getEmail());
        return employeeDto;
    }

    @Override
    public Employee toModel(CreateEmployeeRequestDto requestDto) {
        if (requestDto == null) {
            return null;
        }
        Employee employee = new Employee();
        employee.setName(requestDto.name());
        employee.setEmail(requestDto.email());
        employee.setDepartment(departmentMapper.departmentById(requestDto.departmentId()));
        return employee;
    }
}
