package org.example;

import exceptions.ValidationException;

public class StringUtil {
    public String toUpperCase(String string) throws ValidationException {
        if (string == null) {
            throw new ValidationException("String cannot be null!");
        }
        return string.toUpperCase();
    }
}
