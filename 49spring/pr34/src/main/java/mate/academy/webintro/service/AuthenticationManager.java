package mate.academy.webintro.service;

import lombok.RequiredArgsConstructor;
import mate.academy.webintro.dto.user.UserLoginRequestDto;
import mate.academy.webintro.security.AuthenticationService;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class AuthenticationManager {
    private final AuthenticationService authenticationService;

    public boolean isAuthenticated(Authentication authentication) {
        if (authentication == null) {
            return false;
        }
        String email = (String) authentication.getPrincipal();
        String password = (String) authentication.getCredentials();
        return authenticationService.authenticate(
                new UserLoginRequestDto(email, password)
        );
    }
}
