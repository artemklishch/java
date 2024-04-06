package org.example;

import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        // of
        // empty
        // ofNullable

        Optional<String> of = Optional.of("abc");
        Optional<String> empty = Optional.empty();
        Optional<Object> optional = Optional.ofNullable(null);

//        Optional<String> optionalValue = Optional.of(getElementByIndex(new String[]{}, 2));
        Optional<String> optionalValue = Optional.ofNullable(getElementByIndex(new String[]{}, 2));
        System.out.println(of.get());
        System.out.println(empty.get());
        System.out.println(optional.get());
        System.out.println(optionalValue.get());
    }

    private static String getElementByIndex(String[] values, int index) {
        if (index >= values.length || index < 0) {
            return null;
        }
        return values[index];
    }
}