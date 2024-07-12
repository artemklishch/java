package mate.academy.webintro.repository;

import mate.academy.webintro.model.Phone;
import org.springframework.data.jpa.domain.Specification;

public interface SpecificationProvider<T> {
    String getKey();

    Specification<T> getSpecification(String[] params);
}
