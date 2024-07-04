package mate.academy.webintro.controller;

import lombok.RequiredArgsConstructor;
import mate.academy.webintro.dto.department.CreateDepartmentDto;
import mate.academy.webintro.dto.department.DepartmentDto;
import mate.academy.webintro.service.department.DepartmentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/departments")
public class DepartmentController {
    private final DepartmentService departmentService;

    @GetMapping
    public List<DepartmentDto> getAll() {
        return departmentService.findAll();
    }

    @PostMapping
    public DepartmentDto save(@RequestBody CreateDepartmentDto requestDto) {
        return departmentService.save(requestDto);
    }
}
