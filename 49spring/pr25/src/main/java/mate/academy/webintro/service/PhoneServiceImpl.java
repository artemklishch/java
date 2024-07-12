package mate.academy.webintro.service;

import lombok.RequiredArgsConstructor;
import mate.academy.webintro.dto.CreatePhoneRequestDto;
import mate.academy.webintro.dto.PhoneDto;
import mate.academy.webintro.dto.PhoneSearchParameters;
import mate.academy.webintro.exception.EntityNotFountException;
import mate.academy.webintro.mapper.PhoneMapper;
import mate.academy.webintro.model.Phone;
import mate.academy.webintro.repository.phone.PhoneRepository;
import mate.academy.webintro.repository.phone.PhoneSpecificationBuilder;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class PhoneServiceImpl implements PhoneService {
    private final PhoneRepository phoneRepository;
    private final PhoneMapper phoneMapper;
    private final PhoneSpecificationBuilder phoneSpecificationBuilder;

    @Override
    public PhoneDto save(CreatePhoneRequestDto requestDto) {
        Phone phone = phoneMapper.toModel(requestDto);
        return phoneMapper.toDto(phoneRepository.save(phone));
    }

    @Override
    public List<PhoneDto> findAll() {
        return phoneRepository.findAll().stream()
                .map(phoneMapper::toDto)
                .toList();
    }

    @Override
    public PhoneDto findById(Long id) {
        Phone phone = phoneRepository.findById(id)
                .orElseThrow(() -> new EntityNotFountException(
                        "Can't find phone with id: " + id)
                );
        return phoneMapper.toDto(phone);
    }

    @Override
    public void deleteById(Long id) {
        phoneRepository.deleteById(id);
    }

    @Override
    public List<PhoneDto> search(PhoneSearchParameters params) {
        Specification<Phone> build = phoneSpecificationBuilder.build(params);
        return phoneRepository.findAll(build).stream()
                .map(phoneMapper::toDto)
                .toList();
    }
}
