package org.example;

import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        // boxed + mapToObj
        // boxed - дозволяє зі стріма примітивів отримати стрім об'єктів, упаковокб wrappers (like Integer)
        // mapToObj - дозволяє зі з стріма примітивів отримати стрім будь-яких об'єктів, будь-який тип, не тільки упаковка

        List<String> cities = List.of("Kyiv", "London", "Paris", "Oslo");
        // select all unique symbols
        Set<Character> uniqueCharacters = cities.stream()
                .map(String::chars) // transform into streams of charachters, stream IntStream
                .flatMap(IntStream::boxed) // extracts to one stream of charachters and converts symbols into integers, stream Integer, це стрім символів, представлений у числовому вигляді
                .mapToInt(i -> i) // IntStream, отримуємо стрім примітивів, розпаковуємо числове представлення символів з попереднього рядка в примітиви
                .mapToObj(i -> (char) i) // stream Character, приймає функцію як аргумент, перетворюємо симлове представлення симвлів у символи та у вигляді об'єкта упаковки
                .collect(Collectors.toSet());
        System.out.println(uniqueCharacters);

//    IntStream intStream;
//    intStream.boxed();


    }
}