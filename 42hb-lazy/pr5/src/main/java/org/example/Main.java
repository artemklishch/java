package org.example;

import org.example.dao.OrderDao;
import org.example.dao.ProductDao;
import org.example.dao.ReviewDao;
import org.example.dao.UserDao;
import org.example.dao.impl.OrderDaoImpl;
import org.example.dao.impl.ProductDaoImpl;
import org.example.dao.impl.ReviewDaoImpl;
import org.example.dao.impl.UserDaoImpl;
import org.example.model.Order;
import org.example.model.Product;
import org.example.model.Review;
import org.example.model.User;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Review iPhoneReview = new Review("Awesom phone", null);
        ReviewDao reviewDao = new ReviewDaoImpl();
        reviewDao.save(iPhoneReview);

        Product iPhone = new Product();
        iPhone.setName("iPhone X");
        iPhone.setPrice(BigDecimal.valueOf(999));
        iPhone.setReviews(Set.of(iPhoneReview));
        ProductDao productDao = new ProductDaoImpl();
        productDao.save(iPhone);

        User bob = new User();
        bob.setLogin("Bob");
        bob.setPassword("1234");
        UserDao userDao = new UserDaoImpl();
        userDao.save(bob);

        Order order = new Order();
        order.setOrderDate(LocalDateTime.now());
        order.setOwner(bob);
        order.setProducts(Set.of(iPhone));
        OrderDao orderDao = new OrderDaoImpl();
        orderDao.save(order);

        Order orderFromDB = orderDao.get(order.getId());
        System.out.println("The count of products in this order = " + orderFromDB.getProducts().size());
        System.out.println(orderFromDB);

        for (Product product : orderFromDB.getProducts()) {
            System.out.println(product.getReviews());
        }

    }


}