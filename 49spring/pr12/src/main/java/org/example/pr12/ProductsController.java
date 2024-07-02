package org.example.pr12;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductsController {
//    @GetMapping("/products")
//    public List<Product> getAll() {
//        return List.of(new Product(1L, "Bread"), new Product(2L, "Wine"));
//    }
//
//    @PostMapping("/products")
//    public String save(@RequestBody Product product) { // @RequestBody - we need in order to extract data from the product
//        return "Products was saved. Id: %s, name: %s".formatted(product.id(), product.name());
//    }

    @GetMapping
    public List<Product> getAll() {
        return List.of(new Product(1L, "Bread"), new Product(2L, "Wine"));
    }

    @PostMapping
    public String save(@RequestBody Product product) { // @RequestBody - we need in order to extract data from the product
        return "Products was saved. Id: %s, name: %s".formatted(product.id(), product.name());
    }
}
