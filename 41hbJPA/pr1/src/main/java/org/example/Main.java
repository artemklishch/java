package org.example;

import org.example.dao.JpaProductDaoImpl;
import org.example.dao.ProductDao;
import org.example.dao.ProductDaoImpl;
import org.example.model.Product;

import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {
        ProductDao productDao = new JpaProductDaoImpl();

        Product iPhone = new Product();
        iPhone.setName("iPhone 13");
        iPhone.setPrice(BigDecimal.valueOf(1500));

        Product savedProduct = productDao.save(iPhone);
        System.out.println(savedProduct);
    }
}