package mate.academy.webintro.repository;

import mate.academy.webintro.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends
        JpaRepository<User, Long> {
}
