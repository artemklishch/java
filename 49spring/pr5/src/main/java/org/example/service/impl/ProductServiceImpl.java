package org.example.service.impl;

import org.example.dao.ProductDao;
import org.example.model.Product;
import org.example.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    //    private final ProductDao productDao;
    private ProductDao productDao;

    public ProductDao getProductDao() {
        return productDao;
    }

    @Autowired
    public void setProductDao(ProductDao productDao) {
        this.productDao = productDao;
    }
//    @Autowired
//    public ProductServiceImpl(ProductDao productDao) {
//        this.productDao = productDao;
//    }
//    public ProductServiceImpl(ProductDao productDao) {
//        this.productDao = productDao;
//    } // якщо конструктор приймає всі поля класу, то можемо не писати аннотацію @Autowired
//    // і тільки якщо маємо тільки один конструктор

    @Override
    public Product save(Product product) {
        return productDao.save(product);
    }

    @Override
    public List<Product> findAll() {
        return productDao.findAll();
    }
}
