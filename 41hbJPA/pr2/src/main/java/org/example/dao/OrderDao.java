package org.example.dao;

import org.example.model.Order;

public interface OrderDao {
    Order save(Order order);

    void update(Order order);

    void remove(Order order);
}
