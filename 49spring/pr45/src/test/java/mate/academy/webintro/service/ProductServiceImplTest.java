package mate.academy.webintro.service;

import mate.academy.webintro.dto.product.CreateProductRequestDto;
import mate.academy.webintro.dto.product.ProductDto;
import mate.academy.webintro.mapper.ProductMapper;
import mate.academy.webintro.model.Product;
import mate.academy.webintro.repository.ProductRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ProductServiceImplTest {
    @Mock
    private ProductRepository productRepository;

    @Mock
    private ProductMapper productMapper;

    @InjectMocks
    private ProductServiceImpl productService;

    @Test
    @DisplayName("Verify save(0 method works")
    void save_ValidCreateProductRequestDto_ReturnsProductDto(){
        // Given
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

        // When
        ProductDto savedProductDto = productService.save(requestDto);

        // Then
        assertThat(savedProductDto).isEqualTo(productDto);
        verify(productRepository, times(1)).save(product);
        verifyNoMoreInteractions(productRepository, productMapper);
    }

    @Test
    @DisplayName("Verify save(0 method works")
    void findAll_ValidPageable_ReturnsAllProducts(){
        // Given
        Product product = new Product();
        product.setId(1L);
        product.setTitle("Test Product");
        product.setPrice(BigDecimal.valueOf(100));

        ProductDto productDto = new ProductDto();
        productDto.setId(product.getId());
        productDto.setTitle(product.getTitle());
        productDto.setPrice(product.getPrice());

        Pageable pageable = PageRequest.of(0, 10);
        List<Product> products = List.of(product);
        Page<Product> productPage = new PageImpl<>(products, pageable, products.size());

        when(productRepository.findAll(pageable)).thenReturn(productPage);
        when(productMapper.toDto(product)).thenReturn(productDto);

        // When
        List<ProductDto> productDtos = productService.findAll(pageable);

        // Then
        assertThat(productDtos).hasSize(1);
        assertThat(productDtos.get(0)).isEqualTo(productDto);

        verify(productRepository, times(1)).findAll(pageable);
        verify(productMapper, times(1)).toDto(product);
        verifyNoMoreInteractions(productRepository, productMapper);
    }

    @Test
    @DisplayName("Verify findAll() method with price range works")
    void findAll_ValidPriceRangeAndPageable_ReturnsAllProducts(){
        // given
        BigDecimal fromPrice = BigDecimal.valueOf(50);
        BigDecimal toPrice = BigDecimal.valueOf(200);

        Product product = new Product();
        product.setId(1L);
        product.setTitle("Test Product");
        product.setPrice(BigDecimal.valueOf(100));

        ProductDto productDto = new ProductDto();
        productDto.setId(product.getId());
        productDto.setTitle(product.getTitle());
        productDto.setPrice(product.getPrice());

        Pageable pageable = PageRequest.of(0, 10);
        List<Product> products = Collections.singletonList(product);

        when(productRepository.findAllByPriceBetween(fromPrice, toPrice, pageable)).thenReturn(products);
        when(productMapper.toDto(product)).thenReturn(productDto);

        // when
        List<ProductDto> productDtos = productService.findAllByPriceBetween(fromPrice, toPrice, pageable);

        // then
        assertThat(productDtos).hasSize(1);
        assertThat(productDtos.get(0)).isEqualTo(productDto);
        verify(productRepository, times(1)).findAllByPriceBetween(fromPrice, toPrice, pageable);
        verify(productMapper, times(1)).toDto(product);
        verifyNoMoreInteractions(productRepository, productMapper);
    }

}