package mate.academy.webintro.dto;

import lombok.Data;
import mate.academy.webintro.validation.Email;

@Data
public class CreateUserRequestDto {
    @Email
    private String email;
    private String password;
    private String repeatPassword;
}
