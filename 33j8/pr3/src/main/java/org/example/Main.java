package org.example;

import java.util.List;
import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        List<String> names = List.of("Bob", "Alice", "John");

        // 1. using .stream() method from Collection
        // 2. Stream.of() method
        // 3. Arrays.stream(<some array>) method
        // 4. chars() method
        // 5. Stream.generate() method
        // 6. Stream.iterate() method
        // 7. IntStream.range() method

        names.stream().forEach(System.out::println); // повертає стрім, потім виводить значення

        Stream.of("Bob", "Alice", "John").forEach(System.out::println); // повертає стрім, потім виводить значення

        String[] cities = new String[]{"Kyiv", "London", "Paris"};
        Arrays.stream(cities).forEach(System.out::println);

        String value = "Hello";
        value.chars(); // getting IntStream in this case

        Stream.generate(new Random()::nextInt).limit(5).forEach(System.out::println); // прймає певний Supplier повертає не більше 5 згенерованих елементівб виводить значення

        Stream.iterate(0, i -> i + 2).limit(5).forEach(System.out::println); // виводить числа від нуля в кількості 5 чисел і кожне наступне є більшим за попереднє на 2

        IntStream.range(4, 10).forEach(System.out::println); // виводить діапазон чисел між 4 (включно) до 10 (не включно)
    }
}