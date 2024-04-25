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
        // LOG levels
        // тут вказані виді рівнів в порядку зрпостання обсягу логованої інформації
        // кожний наступний рівень, що нижче, охоплює попередні рівні, наприклад
        // рівень DEBUG буде виводити в тому числі інформацію, віднесену до рівнів OFF, FATAL, ERROR, WARN, INFO
        /*
        * OFF
        * FATAL
        * ERROR
        * WARN
        * INFO
        * DEBUG
        * TRACE
        * ALL
        * */
    }
}