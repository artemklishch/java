package com.example.pr20.dto.product;

import java.util.Set;

public record ProductResponseDto(Long id, String title, Set<Long> categoryIds) {
}
