package mate.academy.webintro.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class SecurityConfig {
    @Bean
    public PasswordEncoder getPasswordEncoder() {
        // $2a$[cost]$[22 character salt][31 character hash] // структура хешуваного паролю
        return new BCryptPasswordEncoder();
    }

    // not working
//    @Bean
//    public UserDetailsService getUserDetailsService(PasswordEncoder passwordEncoder) {
//        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
//        manager.createUser(User.withUsername("bob")
//                .password(passwordEncoder.encode("1234"))
//                .roles("USER")
//                .build());
//        manager.createUser(User.withUsername("admin")
//                .password(passwordEncoder.encode("12345"))
//                .roles("ADMIN")
//                .build());
//        return manager;
//    }
}
