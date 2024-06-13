package org.example.dao;

import org.example.model.Product;

import java.math.BigDecimal;
import java.util.List;

public interface ProductDao {
    Product save(Product product);

    Product get(Long id);

    List<Product> findAllWherePriceBetween(BigDecimal from, BigDecimal to);

    List<Product> findAllWherePriceBetweenAndColorIn(BigDecimal from, BigDecimal to, String[] colors);

    List<Product> findAllWherePriceBetweenOrColorIn(BigDecimal from, BigDecimal to, String[] colors);
}
