package org.example;

import org.example.dao.ProductDao;
import org.example.dao.impl.ProductDaoImpl;
import org.example.model.Product;

import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {
        Product iPhone = new Product();
        iPhone.setName("iPhone X");
        iPhone.setPrice(BigDecimal.valueOf(999));

        Product sumsung = new Product();
        sumsung.setName("Sumsung S20");
        sumsung.setPrice(BigDecimal.valueOf(899));

        ProductDao productDao = new ProductDaoImpl();
        productDao.save(iPhone);
        productDao.save(sumsung);

//        System.out.println(productDao.get(iPhone.getId()));
//        System.out.println(productDao.get(sumsung.getId()));
        System.out.println(productDao.findAllPriceGrater(BigDecimal.valueOf(899.00)));
    }
}