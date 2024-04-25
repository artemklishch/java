package org.example.services;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.exceptions.AuthenticationException;
import org.example.model.User;

public class AuthenticationServiceImpl implements AuthenticationService {
    private static final Logger logger = LogManager.getLogger(AuthenticationServiceImpl.class);

    @Override
    public User login(String login, String password) throws AuthenticationException {
        logger.debug("login method was called. Params: login = {}", login);
//        logger.fatal("I am fatal message");
        User user = findByLogin(login);
        if (!user.getPassword().equals(password)) {
            throw new AuthenticationException("Username or password are incorrect!");
        }
        return user;
    }

    private User findByLogin(String login) {
        return new User(login, "1234"); // this user should be fetched from DB
    }
}
