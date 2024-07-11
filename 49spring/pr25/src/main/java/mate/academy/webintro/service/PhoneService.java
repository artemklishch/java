package mate.academy.webintro.service;

import mate.academy.webintro.dto.CreatePhoneRequestDto;
import mate.academy.webintro.dto.PhoneDto;

import java.util.List;

public interface PhoneService {
    PhoneDto save(CreatePhoneRequestDto requestDto);

    List<PhoneDto> findAll();

    PhoneDto findById(Long id);

    void deleteById(Long id);
}
