package org.example.dao;

import org.example.model.Order;
import org.example.model.User;
import org.example.model.dto.OrdersByUserStatisticDto;

import java.util.List;

public interface OrderDao {
    Order save(Order order);

    Order get(Long id);

    List<Order> findAll(User user);

    List<OrdersByUserStatisticDto> getOrderStatistic();
}
