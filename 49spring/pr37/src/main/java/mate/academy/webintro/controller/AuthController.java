package mate.academy.webintro.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import mate.academy.webintro.dto.user.UserLoginRequestDto;
import mate.academy.webintro.dto.user.UserRegistrationRequestDto;
import mate.academy.webintro.dto.user.UserResponseDto;
import mate.academy.webintro.exception.RegistrationException;
import mate.academy.webintro.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AuthController {
    private final UserService userService;

    @PostMapping("/registration")
    public UserResponseDto registration(@RequestBody @Valid UserRegistrationRequestDto requestDto)
            throws RegistrationException {
        return userService.register(requestDto);
    }

    @PostMapping("/login")
    public boolean login(@RequestBody @Valid UserLoginRequestDto requestDto) {
        return true;
    }
}
