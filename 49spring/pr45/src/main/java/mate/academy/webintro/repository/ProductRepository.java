package mate.academy.webintro.repository;

import mate.academy.webintro.model.Product;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.math.BigDecimal;
import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    @Query("FROM Product p WHERE p.price between ?1 AND ?2")
    List<Product> findAllByPriceBetween(BigDecimal fromPrice, BigDecimal toPrice, Pageable pageable);
}
