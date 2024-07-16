package mate.academy.webintro.repository;

import mate.academy.webintro.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends
        JpaRepository<Product, Long> {
}
