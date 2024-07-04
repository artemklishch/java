package mate.academy.webintro.service;

import mate.academy.webintro.dto.CreateDepartmentDto;
import mate.academy.webintro.dto.DepartmentDto;

import java.util.List;

public interface DepartmentService {
    List<DepartmentDto> findAll();

    DepartmentDto save(CreateDepartmentDto requestDto);
}
