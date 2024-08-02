package mate.academy.webintro.security;

import lombok.RequiredArgsConstructor;
import mate.academy.webintro.dto.user.UserLoginRequestDto;
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
        ) != null;
    }
}
