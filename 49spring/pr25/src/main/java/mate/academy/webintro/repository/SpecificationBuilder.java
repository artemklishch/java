package mate.academy.webintro.repository;

import mate.academy.webintro.dto.PhoneSearchParameters;
import org.springframework.data.jpa.domain.Specification;

public interface SpecificationBuilder<T> {
    Specification<T> build(PhoneSearchParameters searchParameters);
}
