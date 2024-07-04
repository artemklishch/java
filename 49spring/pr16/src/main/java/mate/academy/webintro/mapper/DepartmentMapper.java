package mate.academy.webintro.mapper;

import mate.academy.webintro.config.MapperConfig;
import mate.academy.webintro.dto.CreateDepartmentDto;
import mate.academy.webintro.dto.DepartmentDto;
import mate.academy.webintro.model.Department;
import org.mapstruct.Mapper;
import org.mapstruct.Named;

import java.util.Optional;

@Mapper(config = MapperConfig.class)
public interface DepartmentMapper {
    DepartmentDto toDto(Department department);

    Department toModel(CreateDepartmentDto requestDto);

    @Named("departmentById")
    default Department departmentById(Long id) {
//        if (id == null) {
//            return null;
//        }
//        return new Department(id);
        return Optional.ofNullable(id)
                .map(Department::new).orElse(null);
    }
}
