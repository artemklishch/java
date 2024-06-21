package org.example;

import org.example.dao.ProductDao;
import org.example.dao.impl.ProductDaoImpl;
import org.example.model.Product;
import org.hibernate.SessionFactory;

import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {
       Product iPhone = new Product();
       iPhone.setName("iPhone 7");
       iPhone.setPrice(BigDecimal.valueOf(499));

       ProductDao productDao = new ProductDaoImpl();
       productDao.save(iPhone);

       System.out.println(productDao.get(iPhone.getId()));
       System.out.println(productDao.get(iPhone.getId()));
    }
}