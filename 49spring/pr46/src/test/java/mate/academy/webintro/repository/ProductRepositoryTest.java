package mate.academy.webintro.repository;

import mate.academy.webintro.model.Product;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.PageRequest;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class ProductRepositoryTest {
    @Autowired
    private ProductRepository productRepository;

    @Test
    @DisplayName("""
            Find all products by price is less then  100
            """)
    void findAllByPriceBetween_PriceLessThan100_ReturnsOneItemList() {
        Product book = new Product();
        book.setTitle("Book");
        book.setPrice(BigDecimal.valueOf(49.95));
        productRepository.save(book);

        List<Product> actual = productRepository.findAllByPriceBetween(
                BigDecimal.ZERO, BigDecimal.valueOf(100), PageRequest.of(0, 10)
        );

        assertEquals(1, actual.size());
    }
}