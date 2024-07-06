package mate.academy.webintro.service.department;

import lombok.RequiredArgsConstructor;
import mate.academy.webintro.dto.department.CreateDepartmentDto;
import mate.academy.webintro.dto.department.DepartmentDto;
import mate.academy.webintro.mapper.DepartmentMapper;
import mate.academy.webintro.repository.department.DepartmentRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@RequiredArgsConstructor
@Service
public class DepartmentServiceImpl implements DepartmentService {
    private final DepartmentRepository departmentRepository;
    private final DepartmentMapper departmentMapper;

    @Override
    public List<DepartmentDto> findAll() {
        return departmentRepository.findAll().stream()
                .map(departmentMapper::toDto)
                .toList();
    }

    @Override
    public DepartmentDto save(CreateDepartmentDto requestDto) {
        return departmentMapper.toDto(departmentRepository.save(departmentMapper.toModel(requestDto)));
    }
}
