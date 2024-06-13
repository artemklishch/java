package org.example.dao;

import org.example.model.User;

import java.util.Optional;

public interface UserDao {
    User save(User user);

    User get(Long id);

    Optional<User> findByLogin(String login);
}
