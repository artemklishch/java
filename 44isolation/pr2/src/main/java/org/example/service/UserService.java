package org.example.service;

import org.example.model.User;

import java.util.Optional;

public interface UserService {
    User save(User user);

    Optional<User> findBylogin(String login);
}
