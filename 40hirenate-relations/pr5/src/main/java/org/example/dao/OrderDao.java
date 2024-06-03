package org.example.dao;

import org.example.model.Order;

public interface OrderDao {
    Order save(Order order);

    Order get(Long id);
}
