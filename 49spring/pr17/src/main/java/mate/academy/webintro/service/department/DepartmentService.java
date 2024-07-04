package mate.academy.webintro.service.department;

import mate.academy.webintro.dto.department.CreateDepartmentDto;
import mate.academy.webintro.dto.department.DepartmentDto;

import java.util.List;

public interface DepartmentService {
    List<DepartmentDto> findAll();

    DepartmentDto save(CreateDepartmentDto requestDto);
}
