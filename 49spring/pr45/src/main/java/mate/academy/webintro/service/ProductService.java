package mate.academy.webintro.service;

import mate.academy.webintro.dto.product.CreateProductRequestDto;
import mate.academy.webintro.dto.product.ProductDto;
import org.springframework.data.domain.Pageable;

import java.math.BigDecimal;
import java.util.List;

public interface ProductService {
    ProductDto save(CreateProductRequestDto requestDto);

    List<ProductDto> findAll(Pageable pageable);

    ProductDto findById(Long id);

    void deleteById(Long id);

    List<ProductDto> findAllByPriceBetween(BigDecimal fromPrice, BigDecimal toPrice, Pageable pageable);
}
