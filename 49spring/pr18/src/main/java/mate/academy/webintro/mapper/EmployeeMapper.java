package mate.academy.webintro.mapper;

import mate.academy.webintro.config.MapperConfig;
import mate.academy.webintro.dto.employee.CreateEmployeeRequestDto;
import mate.academy.webintro.dto.employee.EmployeeDto;
import mate.academy.webintro.dto.employee.EmployeeWithoutSkillsDto;
import mate.academy.webintro.model.Employee;
import mate.academy.webintro.model.Skill;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(config = MapperConfig.class, uses = DepartmentMapper.class)
public interface EmployeeMapper {
    @Mapping(source = "department.id", target = "departmentId")
    @Mapping(target = "skillIds", ignore = true)
        // це означає, що ми будемо ігнорувати полу skillIds при дефолтній реалізації метода toDto
    EmployeeDto toDto(Employee employee);

    @AfterMapping // цей метод буде викликаний автоматично після того, як будуте виконана логіка в методі toDto
    default void setSkillsIds(@MappingTarget EmployeeDto employeeDto, Employee employee) {
        List<Long> skillIds = employee.getSkills().stream()
                .map(Skill::getId)
                .toList();
        employeeDto.setSkillIds(skillIds);
    }

    //    @Mapping(target = "department", source = "departmentId", qualifiedByName = "departmentById") // not working
    EmployeeWithoutSkillsDto toEmployeeWithoutSkillsDto(Employee employee);

    @Mapping(target = "department", source = "departmentId", qualifiedByName = "departmentById")
    @Mapping(target = "skills", ignore = true)
    Employee toModel(CreateEmployeeRequestDto requestDto);

    @AfterMapping
    default void setSkills(@MappingTarget Employee employee, CreateEmployeeRequestDto requestDto) {
        List<Skill> skills = requestDto.skills().stream()
                .map(Skill::new)
                .toList();
        employee.setSkills(skills);
    }
}
