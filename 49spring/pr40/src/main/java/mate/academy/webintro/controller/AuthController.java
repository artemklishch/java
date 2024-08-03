package mate.academy.webintro.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import mate.academy.webintro.dto.user.UserLoginRequestDto;
import mate.academy.webintro.dto.user.UserLoginResponseDto;
import mate.academy.webintro.dto.user.UserRegistrationRequestDto;
import mate.academy.webintro.dto.user.UserResponseDto;
import mate.academy.webintro.exception.RegistrationException;
import mate.academy.webintro.security.AuthenticationService;
import mate.academy.webintro.service.UserService;

import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AuthController {
    private final UserService userService;
    private final AuthenticationService authenticationService;

    @PostMapping("/registeration")
    public UserResponseDto registration(
            @RequestBody @Valid UserRegistrationRequestDto requestDto
    ) throws RegistrationException {
        return userService.register(requestDto);
    }

    @PostMapping("/login")
    public UserLoginResponseDto login(
            @RequestBody @Valid UserLoginRequestDto requestDto
    ) {
        return authenticationService.authenticate(requestDto);
    }
}
