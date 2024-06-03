package org.example.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
//    @JoinColumn(name = "user_id", nullable = false)
    @JoinColumn(name = "user_id")
    private User owner;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable( // для певизначення суміжної таблиці
            name = "orders_products", // назва суміжної таблиці
            joinColumns = @JoinColumn(name = "order_id"), // назва однієї колонки
            inverseJoinColumns = @JoinColumn(name = "product_id") // навза другої колонки
    )
    private List<Product> products;

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    private LocalDateTime orderDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDateTime orderDate) {
        this.orderDate = orderDate;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", owner=" + owner +
                ", products=" + products +
                ", orderDate=" + orderDate +
                '}';
    }
}