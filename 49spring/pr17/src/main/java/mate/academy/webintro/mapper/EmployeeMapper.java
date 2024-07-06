package mate.academy.webintro.mapper;

import mate.academy.webintro.config.MapperConfig;
import mate.academy.webintro.dto.employee.CreateEmployeeRequestDto;
import mate.academy.webintro.dto.employee.EmployeeDto;
import mate.academy.webintro.dto.employee.EmployeeWithoutSkillsDto;
import mate.academy.webintro.model.Employee;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

public interface EmployeeMapper {
    @Mapping(source = "department.id", target = "departmentId")
    EmployeeDto toDto(Employee employee);

    @Mapping(target = "department", source = "departmentId", qualifiedByName = "departmentById")
    Employee toModel(CreateEmployeeRequestDto requestDto);

//    EmployeeWithoutSkillsDto toEmployeeWithoutSkillsDto(Employee employee);
}
