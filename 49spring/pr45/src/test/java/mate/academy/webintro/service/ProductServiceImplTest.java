package mate.academy.webintro.service;

import mate.academy.webintro.dto.CreateProductRequestDto;
import mate.academy.webintro.dto.ProductDto;
import mate.academy.webintro.mapper.ProductMapper;
import mate.academy.webintro.mapper.impl.ProductMapperImpl;
import mate.academy.webintro.model.Product;
import mate.academy.webintro.repository.ProductRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ProductServiceImplTest {
    @InjectMocks
    private ProductServiceImpl productService;

    private static ProductRepository productRepository;

    private static ProductMapper productMapper;

    @BeforeAll
    static void setUp(){
        productMapper = mock(ProductMapperImpl.class);
        productRepository = mock(ProductRepository.class);
    }

    @Test
    @DisplayName("Verify save() method works")
    void save_ValidCreateProductRequestDto_ReturnsProductDto() {
        // given
        CreateProductRequestDto requestDto = new CreateProductRequestDto();
        requestDto.setTitle("Test Product");
        requestDto.setPrice(BigDecimal.valueOf(100));

        Product product = new Product();
        product.setTitle(requestDto.getTitle());
        product.setPrice(requestDto.getPrice());

        ProductDto productDto = new ProductDto();
        productDto.setId(1L);
        productDto.setTitle(product.getTitle());
        productDto.setPrice(product.getPrice());

        when(productMapper.toModel(requestDto)).thenReturn(product);
        when(productRepository.save(product)).thenReturn(product);
        when(productMapper.toDto(product)).thenReturn(productDto);

        // when
        ProductDto savedProductDto = productService.save(requestDto);

        // then
        assertThat(savedProductDto).isEqualTo(productDto);
        verify(productRepository, times(1)).save(product);
        verifyNoMoreInteractions(productRepository);
    }

}