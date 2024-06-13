package org.example.dao;

import org.example.model.Order;
import org.example.model.User;

import java.util.List;

public interface OrderDao {
    Order save(Order order);

    Order get(Long id);

    List<Order> findAll(User user);
}
