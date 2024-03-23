package junit.practice.example.service;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GmailValidatorTest {
    private EmailValidator emailValidator = new GmailValidator();

    @Test
    void containsGmailDomen_Ok() {
        java.lang.String email = "valid@gmail.com";
        boolean actual = emailValidator.isValid(email);
        assertTrue(actual);
    }

    @Test
    void startWithNumber_NotOk() {
        java.lang.String email = "456@gmail.com";
        boolean actual = emailValidator.isValid(email);
        assertFalse(actual);
    }

    @Test
    void startWithSymbol_NotOk() {
        java.lang.String email = ":456@gmail.com";
        boolean actual = emailValidator.isValid(email);
        assertFalse(actual);
    }

    @Test
    void containsSymbolsAndLetters_Ok() {
        java.lang.String email = "value$456@gmail.com";
        boolean actual = emailValidator.isValid(email);
        assertTrue(actual);
    }

    @Test
    void nullValue_NotOk() {
//        boolean actual = emailValidator.isValid(null);
//        assertFalse(actual);
        assertThrows(NullPointerException.class, () -> { // лямбда вираз
            emailValidator.isValid(null);
        });
    }
}