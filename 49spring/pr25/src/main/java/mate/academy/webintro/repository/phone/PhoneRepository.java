package mate.academy.webintro.repository.phone;

import mate.academy.webintro.model.Phone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface PhoneRepository extends
        JpaRepository<Phone, Long>,
        JpaSpecificationExecutor<Phone> {
}
