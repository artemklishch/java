package org.example.service;

import org.example.model.User;

import java.util.List;

public interface UserService {
    void add(User user);

    User get(Long id);

    List<User> getAll();
}
