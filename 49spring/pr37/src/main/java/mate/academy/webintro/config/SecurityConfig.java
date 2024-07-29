package mate.academy.webintro.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class SecurityConfig {
    @Bean
    public PasswordEncoder getPasswordEncoder() {
        // $2a$[cost]$[22 character salt][31 character hash] // структура хешуваного паролю
        return new BCryptPasswordEncoder();
    }
}
