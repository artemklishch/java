package mate.academy.webintro.security;

import lombok.RequiredArgsConstructor;
//import mate.academy.webintro.model.User;
import mate.academy.webintro.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {
    private final UserRepository userRepository;

//    private final PasswordEncoder passwordEncoder; // temporal hack to demonstrate password hashing

    @Override
    public UserDetails loadUserByUsername(String email) // here we can pass argument by field of user entity: email, login, phone number
            throws UsernameNotFoundException {
//        User user = userRepository.findByEmail(email)
//                .orElseThrow(
//                        () -> new UsernameNotFoundException("Can't find user by email: " + email)
//                );
//        UserDetails userDetails = org.springframework.security.core.userdetails.User.builder()
//                .username(user.getEmail())
//                .password(user.getPassword())
//                .disabled(!user.isDeleted())
//                .build();
//                return userDetails;
        return userRepository.findByEmail(email)
                .orElseThrow(
                        () -> new UsernameNotFoundException(
                                "Can't find user by email: " + email
                        )
                );
    }
}
