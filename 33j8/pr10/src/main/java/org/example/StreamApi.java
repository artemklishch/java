package org.example;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.NoSuchElementException;

public class StreamApi {
    /**
     * Given a List of Integer numbers,
     * return a sum of odd numbers or 0, if there are no odd numbers in the List.
     */
    public Integer getOddNumsSum(List<Integer> numbers) {
        return numbers.stream()
                .reduce(0, (subtotal, element) -> element % 2 != 0 ? subtotal + element : subtotal);
    }

    /**
     * Given a List of Strings,
     * return a number of times the `element` String occurs in the List.
     */
    public Long calculateOccurrences(List<String> elements, String element) {
//        return (long) elements.stream()
//                .filter(s -> s.equals(element))
//                .toList()
//                .size();
        long val = elements.stream()
                .filter(s -> s.equals(element))
                .toList()
                .size();
        return val;
    }

    /**
     * Given a List of Strings, return the Optional of its first element.
     */
    public Optional<String> getFirstElement(List<String> elements) {
        return elements.stream().findFirst();
    }

    /**
     * Given an array of ints, return three smallest numbers as list in sorted manner.
     * For example for input {4, 1, 10, 20, 11, 3} output will be {1, 3, 4};
     */
    public List<Integer> getThreeSmallestNumbers(int[] numbers) {
        return Arrays.stream(numbers)
                .boxed()
                .sorted()
                .limit(3)
                .toList();
    }

    /**
     * Given a List of Strings,
     * find the String equal to the passed `element` or throw NoSuchElementException.
     */
    public String findElement(List<String> elements, String element) {
        Optional<String> first = elements.stream()
                .filter(s -> s.equals(element))
                .findFirst();
        return first.orElseThrow(() -> new NoSuchElementException("Can't find the element"));
    }
}
