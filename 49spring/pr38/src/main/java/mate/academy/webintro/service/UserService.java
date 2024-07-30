package mate.academy.webintro.service;

import mate.academy.webintro.dto.user.UserRegistrationRequestDto;
import mate.academy.webintro.dto.user.UserResponseDto;
import mate.academy.webintro.exception.RegistrationException;

public interface UserService {
    UserResponseDto register(UserRegistrationRequestDto requestDto) throws RegistrationException;

    UserResponseDto findByEmail(String email);

    UserResponseDto login();
}
