package com.example.pr20.mapper;

import com.example.pr20.config.MapperConfig;
import com.example.pr20.dto.category.CategoryResponseDto;
import com.example.pr20.dto.category.CreateCategoryRequestDto;
import com.example.pr20.dto.product.CreateProductRequestDto;
import com.example.pr20.dto.product.ProductResponseDto;
import com.example.pr20.model.Category;
import com.example.pr20.model.Product;
import org.mapstruct.Mapper;

@Mapper(config = MapperConfig.class)
public interface CategoryMapper {
    CategoryResponseDto toDto(Category category);

    Category toEntity(CreateCategoryRequestDto requestDto);
}