package org.example;

import org.example.dao.*;
import org.example.model.Order;
import org.example.model.Product;
import org.example.model.User;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Product iPhone = new Product();
        iPhone.setName("iPhone X");
        iPhone.setPrice(BigDecimal.valueOf(999));
        ProductDao productDao = new ProductDaoImpl();
        productDao.save(iPhone);
        Product prodFromDB = productDao.get(1L);
        System.out.println(prodFromDB);

        User bob = new User();
        bob.setLogin("Bob");
        bob.setPassword("1234");
        UserDao userDao = new UserDaoImpl();
        userDao.save(bob);
        User userFromDB = userDao.get(1L);

        Order order = new Order();
        order.setOrderDate(LocalDateTime.now());
        order.setOwner(userFromDB);
        order.setProducts(List.of(prodFromDB));
        OrderDao orderDao = new OrderDaoImpl();
        orderDao.save(order);
        Order orderFromDB = orderDao.get(1L);
        System.out.println(orderFromDB);

        Order newOrder = new Order();
        orderDao.save(newOrder);

        Product tv = new Product();
        tv.setName("TV");
        tv.setPrice(BigDecimal.TEN);
        tv.setOrders(List.of(orderDao.get(2L)));
        productDao.save(tv);
    }
}