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

//    private List<Product> products;
//    @ManyToOne // це "головна" анотація, якщо має місце двонаправлені залежності (якщо User також має посилання на Order)
//    private User owner;

@ManyToOne
@JoinColumn(name = "user_id", nullable = false) // це змінює ім'я колонки з owner_id на user_id
private User owner; // nullable по дефолту - true, якщо вказати false то обов'яково не повинно мати значення null

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

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", orderDate=" + orderDate +
                '}';
    }
}
