package org.example.pr6;

import org.example.pr6.model.Product;
import org.example.pr6.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.math.BigDecimal;

@SpringBootApplication
public class Pr6Application {
    @Autowired
    private ProductService productService;

    public static void main(String[] args) {
//        Product product = new Product();
//        product.setName("iPhone");
//        product.setPrice(BigDecimal.ZERO);
        SpringApplication.run(Pr6Application.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner() {
        return new CommandLineRunner() {
            @Override
            public void run(String... args) throws Exception {
                Product iPhone = new Product();
                iPhone.setName("iPhone");
                iPhone.setPrice(BigDecimal.valueOf(999));
                productService.save(iPhone);

                System.out.println(productService.findAll());
            }
        };
    }

}
