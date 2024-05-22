package org.example;
import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;

public class WeightSort {
  public static String orderWeights(String weights) {
    Comparator<String> comparator = new Comparator<String>() {
      @Override
      public int compare(String str1, String str2) {
        int num1 = Arrays.stream(str1.split("")).map(Integer::parseInt).reduce(0, Integer::sum);
        int num2 = Arrays.stream(str2.split("")).map(Integer::parseInt).reduce(0, Integer::sum);
        if (num1 == num2) {
          return str1.compareTo(str2);
        }
        return Integer.compare(num1, num2);
      }
    };
    return Arrays.stream(weights.split(" "))
            .filter(s -> !s.trim().isEmpty())
            .sorted(comparator)
            .collect(Collectors.joining(" "));
  }
}