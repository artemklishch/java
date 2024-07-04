package mate.academy.webintro.dto.employee;

public record CreateEmployeeRequestDto(String name, String email, Long departmentId) {
}
