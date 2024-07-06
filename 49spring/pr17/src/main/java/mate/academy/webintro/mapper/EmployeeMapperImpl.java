package mate.academy.webintro.mapper;

import mate.academy.webintro.dto.employee.CreateEmployeeRequestDto;
import mate.academy.webintro.dto.employee.EmployeeDto;
import mate.academy.webintro.dto.employee.EmployeeWithoutSkillsDto;
import mate.academy.webintro.model.Department;
import mate.academy.webintro.model.Employee;
import mate.academy.webintro.model.Skill;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
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
        if (employee.getDepartment() != null) {
            employeeDto.setDepartmentId(employee.getDepartment().getId());
        }
        setSkillsIds(employeeDto, employee);
        return employeeDto;
    }

    private void setSkillsIds(EmployeeDto employeeDto, Employee employee) {
        List<Long> skills = employee.getSkills().stream()
                .map(Skill::getId)
                .toList();
        employeeDto.setSkills(skills);
    }

//    public EmployeeWithoutSkillsDto toEmployeeWithoutSkillsDto(Employee employee) {
//        if (employee == null) {
//            return null;
//        }
//        EmployeeWithoutSkillsDto employeeDto = new EmployeeWithoutSkillsDto();
//        employeeDto.setId(employee.getId());
//        employeeDto.setName(employee.getName());
//        employeeDto.setEmail(employee.getEmail());
//        if (employee.getDepartment() != null) {
//            employeeDto.setDepartmentId(employee.getDepartment().getId());
//        }
//        return employeeDto;
//    }

    @Override
    public Employee toModel(CreateEmployeeRequestDto requestDto) {
        if (requestDto == null) {
            return null;
        }
        Employee employee = new Employee();
        employee.setName(requestDto.name());
        employee.setEmail(requestDto.email());
        employee.setDepartment(departmentMapper.departmentById(requestDto.departmentId()));

        setSkills(requestDto.skills(), employee);

        return employee;
    }

    private void setSkills(List<Long> skillIds, Employee employee) {
//        List<Skill> skills = new ArrayList<>(skillIds.size());
//        for (Long id : skillIds) {
//            Skill skill = new Skill(id);
//            skills.add(skill);
//        }
//        employee.setSkills(skills);
        List<Skill> skills = skillIds.stream()
                .map(Skill::new)
                .toList();
        employee.setSkills(skills);
    }

}
