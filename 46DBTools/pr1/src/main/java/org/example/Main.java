package org.example;

import org.example.dao.ProductDao;
import org.example.dao.dao.ProductDaoImpl;
import org.example.model.Product;

import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {
        Product iPhone = new Product();
        iPhone.setName("iPhone 7");
        iPhone.setPrice(BigDecimal.valueOf(499));

        Product samsung = new Product();
        samsung.setName("Samsung S20");
        samsung.setPrice(BigDecimal.valueOf(695));

        ProductDao productDao = new ProductDaoImpl();
        productDao.save(iPhone);
        productDao.save(samsung);

        System.out.println(productDao.findAll());


    }
}