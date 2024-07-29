package mate.academy.webintro.dto.user;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

public record UserLoginRequestDto(
        @NotEmpty
        @Length(min = 8, max = 20)
        @Email
        String email,
        @NotEmpty
        @Length(min = 8, max = 20)
        String password
) {

}
