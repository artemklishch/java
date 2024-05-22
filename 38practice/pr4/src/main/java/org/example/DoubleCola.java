package org.example;

import java.util.*;
import java.util.stream.Collectors;

public class DoubleCola {
    //    public static String getNthPerson(String[] names, int n) {
//        if (n <= names.length) {
//            return names[n - 1];
//        }
//        List<String> namesList = new ArrayList<>(Arrays.asList(names));
//        for (int i = 0; i + 1 < n; i++) {
//            String name = namesList.get(i);
//            namesList.add(name);
//            namesList.add(name);
//        }
//        return namesList.get(n - 1);
//    }

//    public static String getNthPerson(String[] names, int n) {
//        if (n <= names.length) {
//            return names[n - 1];
//        }
//        String[] namesValues = new String[n];
//        System.arraycopy(names, 0, namesValues, 0, names.length);
//        int lastIndex = names.length;
//        for (int i = 0; i < n; i++) {
//            String name = namesValues[i];
//            if (lastIndex < n) {
//                namesValues[lastIndex] = name;
//            }
//            if (lastIndex + 1 < n) {
//                namesValues[lastIndex + 1] = name;
//            }
//            lastIndex += 2;
//        }
//        return namesValues[n - 1];
//    }

//    public static String getNthPerson(String[] names, int n) {
//        if (n <= names.length) {
//            return names[n - 1];
//        }
//        Object[] namesInChars = Arrays.stream(names)
//                .map(String::toCharArray)
//                .toArray();
//        Object[] namesValues = new Object[n];
//        for (int i = 0; i < namesInChars.length; i++) {
//            namesValues[i] = namesInChars[i];
//        }
////        System.arraycopy(namesInChars, 0, namesValues, 0, namesInChars.length);
//        int lastIndex = namesInChars.length;
//        for (int i = 0; i < n; i++) {
//            Object name = namesValues[i];
//            if (lastIndex < n) {
//                namesValues[lastIndex] = name;
//            }
//            if (lastIndex + 1 < n) {
//                namesValues[lastIndex + 1] = name;
//            }
//            lastIndex += 2;
//        }
//        return new String((char[]) namesValues[n - 1]);
//    }

//    public static String getNthPerson(String[] names, int n) {
//        if (n <= names.length) {
//            return names[n - 1];
//        }
//        Queue<String> namesValues = new LinkedList<>(Arrays.asList(names));
//        for (int i = 0; i < n; i++) {
//            String name = namesValues.poll();
//            namesValues.offer(name);
//            namesValues.offer(name);
//        }
//        return namesValues.peek();
//    }

    public static String getNthPerson(String[] names, int n) {
        int length = names.length;

        // n - 1, since we are working with 0-based index
        n--;

        // Find the cycle length where n falls into
        int cycle = 1;
        while (n >= length * cycle) {
            n -= length * cycle;
            cycle *= 2;
        }

        // Determine the person at position n
        int index = n / cycle;

        return names[index];
    }
}
