
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
        ProductDao productDao = new ProductDaoImpl();

        Product iPhone = new Product(); // transient
        iPhone.setName("iPhone X");
        iPhone.setPrice(BigDecimal.valueOf(999));

        productDao.save(iPhone);

//        UserDao userDao = new UserDaoImpl();
//        User user = userDao.save(new User());
//        OrderDao orderDao = new OrderDaoImpl();
//        Order order = new Order();
//        order.setOwner(user);
//        orderDao.save(order);
    }
}