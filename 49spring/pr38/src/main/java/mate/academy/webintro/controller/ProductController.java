package mate.academy.webintro.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
public class ProductController {
    @GetMapping
    public String findAll() {
        return "this is a list of products";
    }

    // only admins can access to this endpoint
    @PreAuthorize("hasRole('ROLE_ADMIN')")
//    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    public String create() {
        return "new product was created successfully";
    }
}
