package org.example;

import java.util.Arrays;
public class Printer {
    public String print(String message) {
        return message;
    }

    public String print(double num) {
        StringBuilder builder = new StringBuilder();
        return builder.append(num).toString();
    }

    public String print(String message, int number) {
        StringBuilder builder = new StringBuilder();
        return builder.append(message).append(" and ").append(number).toString();
    }

    public String print(String[] messages) {
        return Arrays.toString(messages);
    }

}
