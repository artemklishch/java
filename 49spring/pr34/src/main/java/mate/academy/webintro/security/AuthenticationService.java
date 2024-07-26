package mate.academy.webintro.security;

import lombok.RequiredArgsConstructor;
import mate.academy.webintro.dto.user.UserLoginRequestDto;
import mate.academy.webintro.model.User;
import mate.academy.webintro.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private final UserRepository userRepository;

    public boolean authenticate(UserLoginRequestDto requestDto) {
        Optional<User> user = userRepository.findByEmail(requestDto.email());
//        if (user.isPresent() && user.get().getPassword().equals(requestDto.password())) {
//            return true;
//        }
//        return false;
        return user.isPresent()
                && user.get()
                .getPassword()
                .equals(requestDto.password());
    }
}
