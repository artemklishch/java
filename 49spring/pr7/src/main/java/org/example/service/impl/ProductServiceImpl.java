package org.example.service.impl;

import org.example.dao.ProductDao;
import org.example.model.Product;
import org.example.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;

/*
1. ClassName: ProductServiceImpl.class
2. Implemented interfaces: [ProductService.class]
3. Depended beans: [productDao]
4. Annotations: [Service]
* */

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductDao productDao;

    @Autowired
    public ProductServiceImpl(ProductDao productDao){
        System.out.println("ProductServiceImpl constructor was called: " +  productDao);
        this.productDao = productDao;
    }

//    @Autowired
//    private ProductDao productDao;
//
//    public ProductServiceImpl() {
//        System.out.println("ProductServiceImpl constructor was called: " + productDao);
//    }

    @PostConstruct
    public void init(){
        System.out.println("ProductServiceImpl init method was called");
    }

//    @Autowired
//    public void setProductDao(ProductDao productDao) {
//        this.productDao = productDao;
//    }


    @Override
    public Product save(Product product) {
        return productDao.save(product);
    }

    @Override
    public List<Product> findAll() {
        return productDao.findAll();
    }

    @PostConstruct
    public void destroy(){
        System.out.println("destroy method was called");
    }

}
