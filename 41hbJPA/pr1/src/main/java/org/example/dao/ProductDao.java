package org.example.dao;

import org.example.model.Product;

public interface ProductDao {
    Product save(Product product);

    Product get(Long id);

    Product remove(Product product);
}
