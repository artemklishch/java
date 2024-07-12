package mate.academy.webintro.repository.phone.spec;

import mate.academy.webintro.model.Phone;
import mate.academy.webintro.repository.SpecificationProvider;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class ColorSpecificationProvider implements SpecificationProvider<Phone> {
    @Override
    public String getKey() {
        return "color";
    }

    public Specification<Phone> getSpecification(String[] params) {
        return (root, query, criteriaBuilder) -> root.get("color").in(Arrays.stream(params).toArray());
    }
}
