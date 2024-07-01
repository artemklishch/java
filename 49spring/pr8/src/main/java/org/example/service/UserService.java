package org.example.service;

import org.example.model.User;

import java.util.List;

public interface UserService {
    void addUser(User user);

    User get(Long id);

    List<User> getAll();
}
