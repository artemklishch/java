package org.example.security;

import org.example.model.User;

public interface AuthenticationService {
    void register(String email, String password);

    User login(String login, String password);
}
