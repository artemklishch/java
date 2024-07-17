package mate.academy.webintro.service;

import mate.academy.webintro.dto.CreateProductRequestDto;
import mate.academy.webintro.dto.ProductDto;

import java.util.List;

public interface ProductService {
    ProductDto save(CreateProductRequestDto requestDto);

    List<ProductDto> findAll();

    ProductDto findById(Long id);

    void deleteById(Long id);
}
