package org.example;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.exceptions.AuthenticationException;
import org.example.services.AuthenticationService;
import org.example.services.AuthenticationServiceImpl;

public class Main {
    public static void main(String[] args) {
        final Logger logger = LogManager.getLogger(Main.class);

        // Logging
        AuthenticationService authenticationService = new AuthenticationServiceImpl();
        try {
//            authenticationService.login("bill", "1234");
            authenticationService.login("bill", "1234dfdfdfdf"); // incorrect password
        } catch (AuthenticationException e) {
            logger.error("Can't login", e);
        }
    }
}