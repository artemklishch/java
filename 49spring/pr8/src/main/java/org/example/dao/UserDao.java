package org.example.dao;

import org.example.model.User;

import java.util.List;

public interface UserDao {
    void add(User user);

    User get(Long id);

    List<User> getAll();
}
