package com.example.pr20.service;

import com.example.pr20.dto.category.CategoryResponseDto;
import com.example.pr20.dto.category.CreateCategoryRequestDto;
import com.example.pr20.dto.product.CreateProductRequestDto;
import com.example.pr20.dto.product.ProductResponseDto;

import java.util.List;

public interface CategoryService {
    List<CategoryResponseDto> findAll();

    CategoryResponseDto save(CreateCategoryRequestDto requestDto);
}
