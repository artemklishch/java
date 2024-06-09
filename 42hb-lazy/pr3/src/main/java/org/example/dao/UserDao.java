package org.example.dao;

import org.example.model.Product;
import org.example.model.User;

import java.math.BigDecimal;
import java.util.List;

public interface UserDao {
    User save(User user);
}
