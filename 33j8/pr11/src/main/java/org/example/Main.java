package org.example;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        StreamApiMedium streamApiMedium = new StreamApiMedium();
        List<String> people = List.of("John Stevenson:2020", "John Stevenson:2020", "John Stevenson:2020", "Andrew Ferguson:2012", "Andrew Ferguson:2020", "Andrew Ferguson:2013");

        System.out.println(streamApiMedium.getVisitorsPerYear(people, 2020));

        Map<String, Integer> income = new HashMap<>();
        income.put("Sun.ltd", 20000);
        income.put("Micro", -5200);
        income.put("Clarity", 0);
        income.put("Odyssey", 9640);
        System.out.println(streamApiMedium.getCompanies(income));

        List<Integer> numbers = List.of(1, 20, 33);
        System.out.println(streamApiMedium.convertAndModifyNumbers(numbers));

        System.out.println(streamApiMedium.charsIncrementation("Hello", 1));

    }
}