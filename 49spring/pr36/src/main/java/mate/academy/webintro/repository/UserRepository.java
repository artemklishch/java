package mate.academy.webintro.repository;

import mate.academy.webintro.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends
        JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
}
