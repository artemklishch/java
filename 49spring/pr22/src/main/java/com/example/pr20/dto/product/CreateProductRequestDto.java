package com.example.pr20.dto.product;

import com.example.pr20.model.Category;

import java.util.Set;

public record CreateProductRequestDto(String title, Set<Category> categories) {
}
