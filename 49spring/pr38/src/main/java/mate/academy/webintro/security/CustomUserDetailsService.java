package mate.academy.webintro.security;

import lombok.RequiredArgsConstructor;
import mate.academy.webintro.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {
    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) // here we can pass argument by field of user entity: email, login, phone number
            throws UsernameNotFoundException {
        return userRepository.findByEmail(email)
                .orElseThrow(
                        () -> new UsernameNotFoundException(
                                "Can't find user by email: " + email
                        )
                );
    }
}
