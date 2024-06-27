package org.example;

import org.example.lib.Injector;
import org.example.model.Product;
import org.example.service.ProductService;

import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {
        /*
        steps:
        1. Add spring-context maven dependency
        2. Create AppConfig class and mark it with @configuration annotation
        3. Replace @Dao and @Service annotations with corresponding from Spring framework
        4. Replace @Inject annotation with @Autowired in ProductServiceImpl
        5. Replace creating of Injector instance with AnnotationConfigApplicationContext
        * */

        Product iPhone = new Product();
        iPhone.setName("iPhone 7");
        iPhone.setPrice(BigDecimal.valueOf(499));

        Product samsung = new Product();
        samsung.setName("Samsung S20");
        samsung.setPrice(BigDecimal.valueOf(695));

        Injector injector = Injector.getInstance("org.example");
        ProductService productService = (ProductService) injector.getInstance(ProductService.class);

        productService.save(iPhone);
        productService.save(samsung);

        System.out.println(productService.findAll());

    }
}