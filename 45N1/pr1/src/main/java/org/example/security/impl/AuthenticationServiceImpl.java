package org.example.security.impl;

import org.example.model.User;
import org.example.security.AuthenticationService;
import org.example.service.UserService;
import org.example.util.HashUtil;

import java.util.Optional;

public class AuthenticationServiceImpl implements AuthenticationService {
    private UserService userService;

    @Override
    public void register(String email, String password) {
//
    }

    @Override
    public User login(String login, String password) {
        Optional<User> userFromDBOptional = userService.findBylogin(login);
        if (userFromDBOptional.isEmpty()) {
//            throw new AuthenticationException("Can't authenticate user");
        }
        User user = userFromDBOptional.get();
        String hashedPassword = HashUtil.hashPassword(password, user.getSalt());

        if (user.getPassword().equals(hashedPassword)) {
            return user;
        }
        // throw new AuthenticationException("Can't authenticate user");
        return null;
    }
}
