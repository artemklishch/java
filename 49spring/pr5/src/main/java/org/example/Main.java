package org.example;

import org.example.config.AppConfig;
import org.example.model.Product;
import org.example.service.ProductService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {

        /*
        1. Add spring-orm and commons-dbcp2 maven dependency
        2. Create DataSource and LocalSessionFactoryBean beans in AppConfig class
        3. Mark them with @Bean annotation
        * */

        Product iPhone = new Product();
        iPhone.setName("iPhone 7");
        iPhone.setPrice(BigDecimal.valueOf(499));

        Product samsung = new Product();
        samsung.setName("Samsung S20");
        samsung.setPrice(BigDecimal.valueOf(695));

        Product samsung10 = new Product();
        samsung10.setName("Samsung S10");
        samsung10.setPrice(BigDecimal.valueOf(400));

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        ProductService productService = context.getBean(ProductService.class);

        productService.save(iPhone);
        productService.save(samsung);
        productService.save(samsung10);

        System.out.println(productService.findAll());
    }
}