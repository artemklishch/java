package com.example.pr20.controller;

import com.example.pr20.dto.category.CategoryResponseDto;
import com.example.pr20.dto.category.CreateCategoryRequestDto;
import com.example.pr20.model.Category;
import com.example.pr20.model.Product;
import com.example.pr20.repository.CategoryRepository;
import com.example.pr20.repository.ProductRepository;
import com.example.pr20.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/categories")
public class CategoryController {
    private final CategoryService categoryService;

    @GetMapping
    public List<CategoryResponseDto> findAll() {
        return categoryService.findAll();
    }

    @PostMapping
    public CategoryResponseDto save(@RequestBody CreateCategoryRequestDto requestDto) {
        return categoryService.save(requestDto);
    }
}
