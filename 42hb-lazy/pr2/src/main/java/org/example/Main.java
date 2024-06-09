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
        System.out.println(orderFromDB.getProducts().size());
        System.out.println(orderFromDB);

        // ways to resolve the laze initialize exception
        // коли ми зазначаємо для fetch = FetchType.LAZY - ми можемо отримти помилку, якщо маємо взаємозалежні поля
        // це відбуваєтьс у випадках використання try with resources - і причина в тому, що ця конструкція закриває сессію до того, як
        // Hibernate намагається зробити запит на отримання сутностей у пов'язаному полі
        // 1. fetch = FetchType.EAGER - bed practice
        // 2. Hibernate.initialize() - not the best solution, like hack
        // 3. join fetch - the best way
    }
}