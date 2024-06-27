package org.example.service.impl;

import org.example.dao.ProductDao;
import org.example.lib.Inject;
import org.example.lib.Service;
import org.example.model.Product;
import org.example.service.ProductService;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Inject
    private ProductDao productDao;

    @Override
    public Product save(Product product) {
        return productDao.save(product);
    }

    @Override
    public List<Product> findAll() {
        return productDao.findAll();
    }
}
