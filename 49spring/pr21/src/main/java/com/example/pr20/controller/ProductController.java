package com.example.pr20.controller;

import com.example.pr20.dto.product.CreateProductRequestDto;
import com.example.pr20.dto.product.ProductResponseDto;
import com.example.pr20.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/products")
public class ProductController {
    private final ProductService productService;

    @GetMapping
    public List<ProductResponseDto> findAll() {
        return productService.findAll();
    }

    @PostMapping
    public ProductResponseDto save(@RequestBody CreateProductRequestDto requestDto) {
        return productService.save(requestDto);
    }
}
