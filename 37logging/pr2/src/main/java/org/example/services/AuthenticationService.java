package org.example.services;

import org.example.exceptions.AuthenticationException;
import org.example.model.User;

public interface AuthenticationService {
    User login(String login, String password) throws AuthenticationException;
}
