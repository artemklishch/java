package com.example.pr20.service;

import com.example.pr20.dto.product.CreateProductRequestDto;
import com.example.pr20.dto.product.ProductResponseDto;
import com.example.pr20.mapper.ProductMapper;
import com.example.pr20.model.Product;
import com.example.pr20.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;

    private final ProductMapper productMapper;

    @Override
    public List<ProductResponseDto> findAll() {
//        productRepository.findById(1L).ifPresent(System.out::println);
//        productRepository.findById(2L).ifPresent(p -> System.out.println(p.hashCode()));

        return productRepository.findAll().stream()
                .map(productMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public ProductResponseDto save(CreateProductRequestDto product) {
        Product entity = productMapper.toEntity(product);
        return productMapper.toDto(productRepository.save(entity));
    }
}
