package org.example.pr6.service;


import org.example.pr6.model.Product;

import java.util.List;

public interface ProductService {
    Product save(Product product);

    List<Product> findAll();
}
