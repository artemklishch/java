package org.example;

import exceptions.ValidationException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringUtilTest {
    StringUtil util = new StringUtil();

    @Test
    void nullValue_NotOk() {
        try {
            util.toUpperCase(null);
        } catch (ValidationException e) {
            return;
        }
        fail("ValiodationException should be thrown is value is null");

//        assertThrows(ValidationException.class, () -> {
//            util.toUpperCase(null);
//        });
    }
}