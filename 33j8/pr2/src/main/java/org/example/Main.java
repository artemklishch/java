package org.example;

import java.util.List;
import java.util.Arrays;
import java.util.stream.Stream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.OptionalInt;

public class Main {
    public static void main(String[] args) {
        List<String> names = List.of("Alice", "Bob", "John");
        Stream<String> namesStream = names.stream();

        // IntStream
        // LongStream
        // DoubleStream

        IntStream intStream = namesStream.mapToInt(String::length); // повертає колекцію довжин слів
        // коли викликаємо послідовність методів на об'єкті stream то не працює - вилітає помилка
        // тому нижче вирази коментуються

//        OptionalInt max = intStream.max(); // повертає найбильше числове значення з колекції intStream
//        System.out.println(max);

//        OptionalInt min = intStream.min(); // повертає найменше числове значення з колекції intStream
//        System.out.println(min);

//        intStream.sum(); // повертає суму
//        LongStream longStream;
//        longStream.mapToInt();

//        Stream<Object> objectStream = intStream.mapToObj(String::valueOf); // трансформуємо стрім примітивів у стрім об'єктів
        Stream<String> stringStream = intStream.mapToObj(String::valueOf);

    }
}