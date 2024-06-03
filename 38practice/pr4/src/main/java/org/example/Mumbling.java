package org.example;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Mumbling {
    public static String mumble(String string) {
        if (string.isEmpty()) {
            return "";
        }
        String[] symbols = string.split("");
        return IntStream.range(0, symbols.length)
                .mapToObj(i -> symbols[i].toUpperCase() + symbols[i].toLowerCase().repeat(i))
                .collect(Collectors.joining("-"));
    }
}
