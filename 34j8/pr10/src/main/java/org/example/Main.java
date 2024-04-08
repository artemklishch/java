package org.example;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        List<String> names = List.of("Rick", "Jessie", "George", "Garold");
        System.out.println(sortNames(names));
        System.out.println(filterLetters("random"));

        List<Car> cars = List.of(new Car(1566, "Ford"), new Car(1955, "Mazda"), new Car(1966, "Honda"));
        System.out.println(CarModels.getCarModels(cars));

        System.out.println(getUniqueNumbers("46444988"));

        String[] strings = new String[]{"b", "abc", "aaa", "bbbb", "cccc"};
        System.out.println(getUppercaseString(strings));
    }

    public static List<String> sortNames(List<String> names) {
        return names.stream().sorted().limit(3).collect(Collectors.toList());
    }

    public static String filterLetters(String input) {
        return IntStream.range(0, input.length())
                .filter(v -> v % 2 == 0)
                .mapToObj(v -> String.valueOf(input.charAt(v)).toUpperCase())
                .collect(Collectors.joining());
    }

    public static List<Character> getUniqueNumbers(String sourceNumber) {
        return sourceNumber.chars()
                .mapToObj(c -> (char) c).distinct().collect(Collectors.toList());
    }

    public static List<String> getUppercaseString(String[] sourceStrings) {
        Predicate<String> stringPredicate = s -> s.length() >= 3 && (s.startsWith("a") || s.startsWith("b"));
        return Arrays.stream(sourceStrings)
                .filter(stringPredicate)
                .map(String::toUpperCase)
                .collect(Collectors.toList());
    }
}