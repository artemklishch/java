package org.example;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class NextBiggerNumber {
//    private static final Set<String> COMBINATIONS = new HashSet<>();
//
//    public static int getNextBiggerNumber(int n) {
//        String string = String.valueOf(n);
//        generatePermutation(string, 0, string.length());
//        List<Integer> sortedCombinations = COMBINATIONS.stream()
//                .map(Integer::valueOf)
//                .sorted()
//                .collect(Collectors.toList());
//        int index = sortedCombinations.indexOf(n);
//        return index + 1 == sortedCombinations.size() ? -1 : sortedCombinations.get(index + 1);
//    }
//
//    private static void generatePermutation(String str, int start, int end) {
//        if (start == end - 1) {
//            COMBINATIONS.add(str);
//        } else {
//            for (int i = start; i < end; i++) {
//                str = swapString(str, start, i);
//                generatePermutation(str, start + 1, end);
//                str = swapString(str, start, i);
//            }
//        }
//    }
//
//    public static String swapString(String a, int i, int j) {
//        char[] b = a.toCharArray();
//        char ch;
//        ch = b[i];
//        b[i] = b[j];
//        b[j] = ch;
//        return String.valueOf(b);
//    }

    public static int getNextBiggerNumber(int n) {
        List<Integer> numbersCheckup = Arrays.stream(String.valueOf(n).split(""))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        int iterationsNumber = 0;
        int res = n;
        for (int i = numbersCheckup.size() - 1; i > 0; i--) {
            iterationsNumber++;
            int prev = numbersCheckup.get(i - 1);
            if (numbersCheckup.get(i) == 0) {
                continue;
            }
            numbersCheckup.set(i - 1, numbersCheckup.get(i));
            numbersCheckup.set(i, prev);
            res = Integer.parseInt(numbersCheckup.stream().map(String::valueOf).collect(Collectors.joining()));
            if (res > n) {
                break;
            }
        }
        if (iterationsNumber > 2) {
            for (int i = numbersCheckup.size() - 1; iterationsNumber > 0; i--) {
                iterationsNumber--;
                int prev = numbersCheckup.get(i - 1);
                numbersCheckup.set(i - 1, numbersCheckup.get(i));
                numbersCheckup.set(i, prev);
                res = Integer.parseInt(numbersCheckup.stream().map(String::valueOf).collect(Collectors.joining()));
                if (res > n) {
                    break;
                }
            }
        }
        if (res > n) {
            return res;
        }
        return -1;
    }
}
