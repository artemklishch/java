package org.example;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.Comparator;
import java.util.NoSuchElementException;

import java.util.Set;

public class StreamApiMedium {
    /**
     * Given list strings representing records of patients' visits to a Hospital
     * {"John Stevenson:2020", "Andrew Ferguson:2012", "Andrew Ferguson:2013"}.
     * Return number of unique persons who have visited hospital during the given year (second input param).
     * Be careful, because one person may visit a hospital several times per year and for each visit new record
     * will be generated. Result shouldn't contain duplicates.
     */
    public long getVisitorsPerYear(List<String> records, int year) {
        return records.stream()
                .filter(r -> Integer.valueOf(r.split(":")[1]) == year)
                .collect(Collectors.toSet()).size();
    }

    /**
     * Given a map with the following view : "company name" - "monthly income delta"  (String/Integer)
     * Return list of the companies with positive delta. Their names should be sorted alphabetically
     * Example input : {"Sun.ltd" : 20_000}, {"Micro" : -5_200}, {"Clarity": 0}, {"Odyssey": 9_640};
     * Output : {"Odyssey", "Sun.ltd"}
     */
    public List<String> getCompanies(Map<String, Integer> input) {
        return input.entrySet().stream()
                .filter(c -> c.getValue() > 0)
                .map(c -> c.getKey())
                .sorted()
                .collect(Collectors.toList());
    }

    /**
     * Given a list of integer numbers, convert each integer into its' binary representation in string format
     * and join all of them into a single string and putting each value into brackets, it should look like this:
     * Input: {1, 20, 33}
     * Output:
     * (1)
     * (10100)
     * (100001)
     */
    public String convertAndModifyNumbers(List<Integer> numbers) {
//        return numbers.stream()
//                .map(n -> "(" + Integer.toBinaryString(n) + ")" + System.lineSeparator())
//                .reduce("", (acc, value) -> acc + value);

        return numbers.stream()
                .map(n -> "(" + Integer.toBinaryString(n) + ")")
                .collect(Collectors.joining(System.lineSeparator()));

//        StringBuilder stringBuilder = new StringBuilder();
//        stringBuilder.append("[");
//        numbers.stream()
//                .map(n -> "(" + Integer.toBinaryString(n) + ")")
//                .forEach(stringBuilder::append);
//        stringBuilder.append("]");
//        return stringBuilder.toString();
    }

    /**
     * Given string value. Your task is
     * to increment char value of each symbol from the string. Amount to increment is
     * passed with the second input param - 'increment'
     */
    public String charsIncrementation(String string, int increment) {
        StringBuilder stringBuilder = new StringBuilder();
        string.chars()
                .map(v -> v + increment)
                .mapToObj(c -> (char) c).forEach(v -> stringBuilder.append(v));
        return stringBuilder.toString();
    }

    /**
     * Given List of string where each element represents persons' age and name:
     * {"99:Johny", "20:Brad", ...} return the age of the oldest person
     */
    public Long getOldestPersonAge(List<String> people) {
//        long maxAge = 0L;
//        people.stream()
//                .max(s -> Long.parseLong(s.split(":")[0]))
//                .forEach(v -> {
//                    long maxAge = 0L;
//                    if (v > maxAge) {
//                        maxAge = v;
//                    }
//                });
//        return maxAge;
        if (people.isEmpty()) {
            throw new NoSuchElementException("Empty list");
        }
        List<String> strings = people.stream()
                .map(s -> s.split(":")[0])
                .sorted()
                .collect(Collectors.toList());
        return Long.parseLong(strings.get(strings.size() - 1));
    }
}
