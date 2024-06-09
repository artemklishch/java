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
        initAliceOrders();
        initJohnOrders();
        initBobOrders();

        OrderDao orderDao = new OrderDaoImpl();
        System.out.println("Statistic: " + orderDao.getOrderStatistic());
    }

    private static void initAliceOrders() {
        User alice = new User();
        alice.setLogin("Alice");
        alice.setPassword("1234");
        UserDao userDao = new UserDaoImpl();
        userDao.save(alice);

        OrderDao orderDao = new OrderDaoImpl();
        orderDao.save(new Order(alice));
        orderDao.save(new Order(alice));
        orderDao.save(new Order(alice));
        orderDao.save(new Order(alice));
        orderDao.save(new Order(alice));
    }

    private static void initJohnOrders() {
        User john = new User();
        john.setLogin("John");
        john.setPassword("1234");
        UserDao userDao = new UserDaoImpl();
        userDao.save(john);

        OrderDao orderDao = new OrderDaoImpl();
        orderDao.save(new Order(john));
        orderDao.save(new Order(john));
    }

    private static void initBobOrders() {
        User bob = new User();
        bob.setLogin("Bob");
        bob.setPassword("1234");
        UserDao userDao = new UserDaoImpl();
        userDao.save(bob);

        OrderDao orderDao = new OrderDaoImpl();
        orderDao.save(new Order(bob));
        orderDao.save(new Order(bob));
        orderDao.save(new Order(bob));
        orderDao.save(new Order(bob));
    }
}