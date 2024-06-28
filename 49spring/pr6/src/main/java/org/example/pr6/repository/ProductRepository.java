package org.example.pr6.repository;

import org.example.pr6.model.Product;

import java.util.List;

public interface ProductRepository {
    Product save(Product product);

    List<Product> findAll();
}
