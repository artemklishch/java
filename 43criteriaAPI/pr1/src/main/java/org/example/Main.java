package org.example;

import org.example.dao.ProductDao;
import org.example.dao.impl.ProductDaoCriteriaQueryImpl;
import org.example.model.Product;

import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {
        injectProducts();

        ProductDao productDao = new ProductDaoCriteriaQueryImpl();
        System.out.println(productDao.findAllWherePriceBetween(BigDecimal.valueOf(998), BigDecimal.valueOf(1150)));
        String[] colors = {"red", "yellow"};
        System.out.println(productDao.findAllWherePriceBetweenAndColorIn(BigDecimal.valueOf(100), BigDecimal.valueOf(900), colors));
        System.out.println(productDao.findAllWherePriceBetweenOrColorIn(BigDecimal.valueOf(600), BigDecimal.valueOf(700), colors));
    }

    private static void injectProducts() {
        ProductDao productDao = new ProductDaoCriteriaQueryImpl();

        productDao.save(new Product("iPhone X", "white", BigDecimal.valueOf(699)));
        productDao.save(new Product("iPhone X", "red", BigDecimal.valueOf(899)));
        productDao.save(new Product("iPhone X", "black", BigDecimal.valueOf(999)));
        productDao.save(new Product("Samsung S10", "black", BigDecimal.valueOf(1199)));
        productDao.save(new Product("Samsung S10", "red", BigDecimal.valueOf(999)));
        productDao.save(new Product("Samsung S10", "yellow", BigDecimal.valueOf(1099)));
        productDao.save(new Product("Xiaomi Mi 11", "yellow", BigDecimal.valueOf(599)));
    }
}