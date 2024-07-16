package mate.academy.webintro.service;

import mate.academy.webintro.dto.CreateUserRequestDto;
import mate.academy.webintro.dto.UserDto;

import java.util.List;

public interface UserService {
    UserDto save(CreateUserRequestDto requestDto);

    List<UserDto> findAll();

    UserDto findById(Long id);

    void deleteById(Long id);
}
