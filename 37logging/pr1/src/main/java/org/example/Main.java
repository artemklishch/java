package org.example;

import org.example.exceptions.AuthenticationException;
import org.example.services.AuthenticationService;
import org.example.services.AuthenticationServiceImpl;

public class Main {
    public static void main(String[] args) throws AuthenticationException {
        // Logging
        AuthenticationService authenticationService = new AuthenticationServiceImpl();
        authenticationService.login("bill", "1234");
    }
}