package org.example.t2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.boot.autoconfigure.webservices.WebServicesProperties;

import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

@SpringBootApplication
public class T2Application {

    public static void main(String[] args) {
//        List<String> validTestData = List.of("acs", "qkd", "sde", "cdk", "ams", "sde", "cdk");
//        List<String> validTestExpected = List.of("cs", "de", "de", "dk", "dk", "kd", "ms");
//        List<String> singleElementTestData = List.of("s");
//        List<String> singleElementTestExpected = List.of("");
//        List<String> twoElementsTestData = List.of("abc", "ksk");
//        List<String> twoElementsTestExpected = List.of("bc", "sk");
//        List<String> emptyListTestData = List.of();
//        System.out.println(removeAndSort(validTestData));
//        System.out.println(removeAndSort(singleElementTestData));
//        System.out.println(removeAndSort(twoElementsTestData));
//        System.out.println(removeAndSort(emptyListTestData));

//        String keyword = "ams";
//        List<String> validTestData = List.of("acs", "qkd", "sde", "cdk", "ams", "sde", "cdk");
//        List<String> invalidOrderTestData = List.of("ams", "sde", "cdk", "sde", "q", "cdk");
//        List<String> missingTargetWordData = List.of("acs", "qkd", "sde", "cdk", "sde", "cdk");
//        List<String> emptyListTestData = List.of();
//        System.out.println(containsWord(emptyListTestData, keyword));

//        List<Integer> validTest = List.of(23, 1, 21, 4, 56, 11, 7, 20);
//        List<Integer> singleOddElementTest = List.of(23);
//        List<Integer> singleEvenElementTest = List.of(6);
//        List<Integer> emptyListTest = Collections.EMPTY_LIST;
//        System.out.println(oddSum(emptyListTest));

        List<Integer> validTest = List.of(23, 1, 21, 4, 56, 11, 7, 20);
        List<Integer> secondValisdTest = List.of(5, 1, 6, 4, 10);
        List<Integer> singleOddElementTest = List.of(23);
        List<Integer> emptyListTest = Collections.EMPTY_LIST;
        System.out.println(getOddAverage(validTest)); // 25.75

        WebServicesProperties.Servlet sdfg = null;
    }

    private static List<String> removeAndSort(List<String> input) {
        // WRITE YOUR CODE BELOW THIS LINE
        return input.stream()
                .map(s -> s.substring(1))
                .sorted()
                .toList();
        // WRITE YOUR CODE ABOVE THIS LINE
    }

    private static boolean containsWord(List<String> input, String keyWord) {
        // WRITE YOUR CODE BELOW THIS LINE
        if (input.isEmpty() || input.size() == 1) {
            return false;
        }
        List<String> sublist = input.subList(input.size() / 2, input.size());
        return sublist.stream()
                .anyMatch(keyWord::equals);
        // WRITE YOUR CODE ABOVE THIS LINE
    }

    private static int oddSum(List<Integer> input) {
        // WRITE YOUR CODE BELOW THIS LINE
        return input.stream()
                .mapToInt(Integer::intValue)
                .filter(n -> n % 2 != 0)
                .sum();
        // WRITE YOUR CODE ABOVE THIS LINE
    }

    private static double getOddAverage(List<Integer> input) {
        // WRITE YOUR CODE BELOW THIS LINE
        return IntStream.range(0, input.size())
                .filter(i -> i % 2 != 0)
                .mapToDouble(input::get)
                .map(n -> n - 1)
                .average().orElse(0.0);
//        return input.stream()
//                .mapToDouble(Integer::doubleValue)
//                .filter(n -> n % 2 != 0)
//                .average().orElse(0.0);
        // WRITE YOUR CODE ABOVE THIS LINE
    }
}
