package mate.academy.webintro.security;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SecurityContext {
    private Authentication authentication;
}
