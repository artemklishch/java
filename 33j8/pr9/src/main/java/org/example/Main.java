package org.example;

import java.util.List;
import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        // find first
        System.out.println(getFirst('K'));
        System.out.println(checkIfExist('K'));
        // .parallel - makes parrallel streams and makes the speed faster
    }

    private static String getFirst(char letter) {
        List<String> cities = List.of("Kyiv", "Kyoto", "Oslo", "Antananarivo", "Vinnitsa");
        Optional<String> first = cities.stream()
                .filter(s -> s.charAt(0) == letter)
                .findFirst(); // .findAny - not always the first element
//        return first.get();
        return first.orElseThrow(() -> new RuntimeException("Can't find the city"));
    }

    private static boolean checkIfExist(char letter) {
        List<String> cities = List.of("Kyiv", "Kyoto", "Oslo", "Antananarivo", "Vinnitsa");
        boolean exist = cities.stream()
                .anyMatch(s -> s.charAt(0) == letter);
        return exist;
    }
}