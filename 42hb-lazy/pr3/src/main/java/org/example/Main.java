package org.example;

import org.example.dao.OrderDao;
import org.example.dao.ProductDao;
import org.example.dao.UserDao;
import org.example.dao.impl.OrderDaoImpl;
import org.example.dao.impl.ProductDaoImpl;
import org.example.dao.impl.UserDaoImpl;
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

        User bob = new User();
        bob.setLogin("bob");
        bob.setPassword("1234");
        UserDao userDao = new UserDaoImpl();
        userDao.save(bob);

        Order order = new Order();
        order.setOrderDate(LocalDateTime.now());
        order.setOwner(bob);
        order.setProducts(List.of(iPhone));
        OrderDao orderDao = new OrderDaoImpl();
        orderDao.save(order);

        Order orderFromDB = orderDao.get(order.getId());
        System.out.println("The count of products in this order = " + orderFromDB.getProducts().size());
        System.out.println(orderFromDB);

        Order order2 = new Order();
        order2.setOwner(bob);
        orderDao.save(order2);
        System.out.println(orderDao.findAll(bob));
    }
}