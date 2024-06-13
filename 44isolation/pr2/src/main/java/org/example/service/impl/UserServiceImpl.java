package org.example.service.impl;

import org.example.dao.UserDao;
import org.example.model.User;
import org.example.service.UserService;
import org.example.util.HashUtil;

import java.util.Optional;

public class UserServiceImpl implements UserService {
    private UserDao userDao;

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public User save(User user) {
        user.setSalt(HashUtil.getSalt());
        user.setPassword(HashUtil.hashPassword(user.getPassword(), user.getSalt()));
        return userDao.save(user);
    }

    @Override
    public Optional<User> findBylogin(String login) {
        return userDao.findByLogin(login);
    }
}
