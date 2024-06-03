package org.example.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.math.BigDecimal;

@Entity
@Table(name = "products")
public class Product {
    private Long id;
    private String name;
    private BigDecimal price;
}
