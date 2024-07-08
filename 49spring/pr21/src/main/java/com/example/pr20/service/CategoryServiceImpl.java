package com.example.pr20.service;

import com.example.pr20.dto.category.CategoryResponseDto;
import com.example.pr20.dto.category.CreateCategoryRequestDto;
import com.example.pr20.dto.product.CreateProductRequestDto;
import com.example.pr20.dto.product.ProductResponseDto;
import com.example.pr20.mapper.CategoryMapper;
import com.example.pr20.mapper.ProductMapper;
import com.example.pr20.model.Category;
import com.example.pr20.model.Product;
import com.example.pr20.repository.CategoryRepository;
import com.example.pr20.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;

    private final CategoryMapper categoryMapper;

    @Override
    public List<CategoryResponseDto> findAll() {
//        productRepository.findById(1L).ifPresent(System.out::println);
//        productRepository.findById(2L).ifPresent(p -> System.out.println(p.hashCode()));

        return categoryRepository.findAll().stream()
                .map(categoryMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public CategoryResponseDto save(CreateCategoryRequestDto requestDto) {
        Category entity = categoryMapper.toEntity(requestDto);
        return categoryMapper.toDto(categoryRepository.save(entity));
    }
}
