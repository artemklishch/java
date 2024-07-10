package com.example.pr20.service;

import com.example.pr20.dto.product.CreateProductRequestDto;
import com.example.pr20.dto.product.ProductResponseDto;
import com.example.pr20.model.Product;

import java.util.List;

public interface ProductService {
    List<ProductResponseDto> findAll();

    ProductResponseDto save(CreateProductRequestDto requestDto);
}
