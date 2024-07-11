package mate.academy.webintro.repository;

import mate.academy.webintro.dto.PhoneSearchParameters;
import mate.academy.webintro.model.Phone;
import org.springframework.data.jpa.domain.Specification;

public class PhoneSpecificationBuilder implements SpecificationBuilder<Phone> {
    @Override
    public Specification<Phone> build(PhoneSearchParameters searchParameters) {
        return null;
    }
}
