package org.example;

import org.example.dao.*;
import org.example.model.Order;
import org.example.model.Product;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Product iPhone = new Product();
        iPhone.setName("iPhone 13");
        iPhone.setPrice(BigDecimal.valueOf(1500));

        Order order = new Order();
        order.setProducts(List.of(iPhone));

        OrderDao orderDao = new OrderDaoImpl();
        orderDao.save(order);
    }
}