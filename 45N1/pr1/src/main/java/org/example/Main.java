package org.example;

import org.example.dao.UserDao;
import org.example.dao.impl.UserDaoImpl;
import org.example.model.User;
import org.example.util.HashUtil;

public class Main {
    public static void main(String[] args) {
        User bob = new User();
        bob.setLogin("Bob");
        bob.setSalt(HashUtil.getSalt());
        bob.setPassword(HashUtil.hashPassword("qwerty", bob.getSalt()));

        User alice = new User();
        alice.setLogin("Alice");
        alice.setPassword("123456");

        User john = new User();
        john.setLogin("John");
        john.setPassword("helloworld");

        UserDao userDao = new UserDaoImpl();
        userDao.save(bob);
        userDao.save(alice);
        userDao.save(john);
    }
}