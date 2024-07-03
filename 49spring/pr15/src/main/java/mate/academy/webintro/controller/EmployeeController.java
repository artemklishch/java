package mate.academy.webintro.controller;

import lombok.RequiredArgsConstructor;
import mate.academy.webintro.dto.CreateEmployeeRequestDto;
import mate.academy.webintro.dto.EmployeeDto;
import mate.academy.webintro.model.Employee;
import mate.academy.webintro.service.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    @GetMapping
    public List<EmployeeDto> findAll() {
        return employeeService.findAll();
    }

    @GetMapping("/{id}") // dynamic parameter
    public EmployeeDto findById(@PathVariable Long id) {
        // @PathVariable means that we form endpoint like http://localhost:8080/employees/1
        return employeeService.findById(id);
    }

    @GetMapping("/by-name")
    public List<EmployeeDto> getAllByName(@RequestParam String name) {
        // http:localhost:8080/employees/by-name?name=Bob // @RequestParam extracts the query parameter
        return employeeService.findAllByName(name);
    }

    @PostMapping
    public EmployeeDto save(@RequestBody CreateEmployeeRequestDto requestDto) {
        return employeeService.save(requestDto);
    }
}
