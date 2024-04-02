package org.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        StreamApi streamApi = new StreamApi();
        List<Integer> integers = new ArrayList<>();
        integers.add(1);
        integers.add(2);
        integers.add(3);
        integers.add(4);
        System.out.println(streamApi.getOddNumsSum(integers));

        List<String> strings = new ArrayList<>();
        strings.add("Bob");
        strings.add("John");
        strings.add("Bob");
        strings.add("Alice");
        strings.add("Tom");
        System.out.println(streamApi.calculateOccurrences(strings, "Bob"));

        List<String> cities = List.of("Kyiv", "Kyoto", "Oslo", "Antananarivo", "Vinnitsa");
        System.out.println(streamApi.getFirstElement(cities));

        int[] numbers = new int[]{4, 1, 10, 20, 11, 3};
        System.out.println(streamApi.getThreeSmallestNumbers(numbers));

        System.out.println(streamApi.findElement(cities, "Oslo"));
    }
}