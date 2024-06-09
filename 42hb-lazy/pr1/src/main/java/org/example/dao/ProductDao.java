package org.example.dao;

import org.example.model.Product;

import java.math.BigDecimal;
import java.util.List;

public interface ProductDao {
    Product save(Product product);

    Product get(Long id);

    List<Product> findAll();

    List<Product> findAllPriceGrater(BigDecimal price);
}
