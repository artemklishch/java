package org.example;

import java.util.ArrayList;
import java.util.List;

public class OddNumbers {
    public static int getSumOfRow(int n) {
        if (n == 1) {
            return 1;
        }
        int level = 2;
        int firstNum = 2;
        int count = 0;
        while(level < n) {
            if (firstNum % 2 != 0) {
                count++;
            }
            if (count == level) {
                level++;
                count = 0;
            }
            firstNum++;
        }
        List<Integer> numbers = new ArrayList<>();
        for (int i = firstNum; i < firstNum + n * 2; i++) {
            if (i % 2 != 0) {
                numbers.add(i);
            }
        }
        return numbers.stream().reduce(0, Integer::sum);
    }
}
