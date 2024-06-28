package org.example.service;

import org.example.model.Product;

import java.util.List;

public interface ProductService {
    Product save(Product product);

    List<Product> findAll();
}
