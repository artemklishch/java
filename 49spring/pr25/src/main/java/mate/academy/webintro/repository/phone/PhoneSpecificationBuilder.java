package mate.academy.webintro.repository.phone;

import lombok.RequiredArgsConstructor;
import mate.academy.webintro.dto.PhoneSearchParameters;
import mate.academy.webintro.model.Phone;
import mate.academy.webintro.repository.SpecificationBuilder;
import mate.academy.webintro.repository.SpecificationProviderManager;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class PhoneSpecificationBuilder implements SpecificationBuilder<Phone> {
//    @Autowired
//    private SpecificationProviderManager<Phone> phoneSpecificationProviderManager;

    private final SpecificationProviderManager<Phone> phoneSpecificationProviderManager;

    @Override
    public Specification<Phone> build(PhoneSearchParameters searchParameters) {
        Specification<Phone> spec = Specification.where(null);
        if (searchParameters.models() != null && searchParameters.models().length > 0) {
            spec = spec.and(phoneSpecificationProviderManager
                    .getSpecificationProvider("model")
                    .getSpecification(searchParameters.models()));
        }
        if (searchParameters.colors() != null && searchParameters.colors().length > 0) {
            spec = spec.and(phoneSpecificationProviderManager
                    .getSpecificationProvider("color")
                    .getSpecification(searchParameters.colors()));
        }
        return spec;
    }

//    @Override
//    public Specification<Phone> build(PhoneSearchParameters searchParameters) {
//        Specification<Phone> spec = Specification.where(null);
//        if (searchParameters.models() != null && searchParameters.models().length > 0) {
//            spec = spec.and(new ModelspecificationProvider().getSpecification(searchParameters.models()));
//        }
//        if (searchParameters.colors() != null && searchParameters.colors().length > 0) {
//            spec = spec.and(new ColorSpecificationProvider().getSpecification(searchParameters.colors()));
//        }
//        return spec;
//    }
}
