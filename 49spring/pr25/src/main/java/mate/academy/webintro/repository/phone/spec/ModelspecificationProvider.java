package mate.academy.webintro.repository.phone.spec;

import mate.academy.webintro.model.Phone;
import mate.academy.webintro.repository.SpecificationProvider;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class ModelspecificationProvider implements SpecificationProvider<Phone> {
    @Override
    public String getKey() {
        return "model";
    }

    public Specification<Phone> getSpecification(String[] params) {
//        return new Specification<Phone>() {
//                        @Override
//            public Predicate toPredicate(Root<Phone> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
//                return root.get("model").in(Arrays.stream(params).toArray());
//            }
//        };
        return (root, query, criteriaBuilder) -> root.get("model").in(Arrays.stream(params).toArray());
    }
}
