package org.example.dao;

import org.example.model.Product;

import java.util.List;

public interface ProductDao {
    Product save(Product product);

    List<Product> findAll();
}
