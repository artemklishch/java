package mate.academy.webintro.repository.phone;

import lombok.RequiredArgsConstructor;
import mate.academy.webintro.dto.PhoneSearchParameters;
import mate.academy.webintro.model.Phone;
import mate.academy.webintro.repository.SpecificationProvider;
import mate.academy.webintro.repository.SpecificationProviderManager;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import java.util.List;

@RequiredArgsConstructor
@Component
public class PhoneSpecificationProviderManager implements SpecificationProviderManager<Phone> {
//    @Autowired
//    private List<SpecificationProvider<Phone>> phoneSpecificationProviderProviders;

    private final List<SpecificationProvider<Phone>> phoneSpecificationProviderProviders;

    @Override
    public SpecificationProvider<Phone> getSpecificationProvider(String key) {
        return phoneSpecificationProviderProviders.stream()
                .filter(p -> p.getKey().equals(key))
                .findFirst()
                .orElseThrow(
                        () -> new RuntimeException(
                                "Can't find correct specification provider for key: " + key
                        )
                );
    }
}
