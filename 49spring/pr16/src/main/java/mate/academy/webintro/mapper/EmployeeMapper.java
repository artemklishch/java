//package mate.academy.webintro.mapper;
//
//import mate.academy.webintro.dto.CreateEmployeeRequestDto;
//import mate.academy.webintro.dto.EmployeeDto;
//import mate.academy.webintro.model.Employee;
//import org.mapstruct.Mapping;
//
//public interface EmployeeMapper {
//    EmployeeDto toDto(Employee employee);
//
//    Employee toModel(CreateEmployeeRequestDto requestDto);
//}

package mate.academy.webintro.mapper;

import mate.academy.webintro.config.MapperConfig;
import mate.academy.webintro.dto.CreateEmployeeRequestDto;
import mate.academy.webintro.dto.EmployeeDto;
import mate.academy.webintro.model.Employee;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(config = MapperConfig.class, uses = DepartmentMapper.class)
public interface EmployeeMapper {
    @Mapping(source = "department.id", target = "departmentId")
    EmployeeDto toDto(Employee employee);

    @Mapping(target = "department", source = "departmentId", qualifiedByName = "departmentById")
    Employee toModel(CreateEmployeeRequestDto requestDto);
}
