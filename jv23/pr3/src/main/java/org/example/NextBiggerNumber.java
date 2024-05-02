package org.example;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class NextBiggerNumber {
    private static final Set<String> COMBINATIONS = new HashSet<>();

    public static int getNextBiggerNumber(int n) {
        String string = String.valueOf(n);
        generatePermutation(string, 0, string.length());
        List<Integer> sortedCombinations = COMBINATIONS.stream()
                .map(Integer::valueOf)
                .sorted()
                .collect(Collectors.toList());
        int index = sortedCombinations.indexOf(n);
        return index + 1 == sortedCombinations.size() ? -1 : sortedCombinations.get(index + 1);
    }

    private static void generatePermutation(String str, int start, int end) {
        if (start == end - 1) {
            COMBINATIONS.add(str);
        } else {
            for (int i = start; i < end; i++) {
                str = swapString(str, start, i);
                generatePermutation(str, start + 1, end);
                str = swapString(str, start, i);
            }
        }
    }

    public static String swapString(String a, int i, int j) {
        char[] b = a.toCharArray();
        char ch;
        ch = b[i];
        b[i] = b[j];
        b[j] = ch;
        return String.valueOf(b);
    }
}
