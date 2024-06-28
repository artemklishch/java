package org.example.pr6.service;

import org.example.pr6.model.Product;
import org.example.pr6.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    private ProductRepository productRepository;

    public ProductRepository getProductDao() {
        return productRepository;
    }

    @Autowired
    public void setProductDao(ProductRepository productDao) {
        this.productRepository = productDao;
    }

    @Override
    public Product save(Product product) {
        return productRepository.save(product);
    }

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }
}
