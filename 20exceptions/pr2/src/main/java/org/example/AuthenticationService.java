package org.example;

import org.example.exceptions.AuthenticationException;

public class AuthenticationService {
    public void authenticate(String login, String password) throws AuthenticationException {
        if (password.length() < 8) {
            throw new AuthenticationException("The password is too short");
        }
    }
}
