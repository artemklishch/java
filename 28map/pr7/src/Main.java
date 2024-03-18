import java.util.Arrays;
import java.util.Map;
import java.lang.String;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        int[][] m1 = {
                {10, 20, 30, -10},
        };
        int[][] m2 = {
        };


        int[][] res = addMatrix(m1, m2);

        int[] prettyArray = new int[]{2, 10, 3, 9};
        System.out.println(isArrayPretty(prettyArray));

        Map<String, Integer> data = new HashMap<>();
        data.put("myhelloworld", 4);
        data.put("Hello", 7);
        data.put("Awsesome", 8);
        data.put("Wow!!! HELLO", 9);
        int sum = calculateSum(data, "hello");
        System.out.println(sum);
    }

    public static int[][] addMatrix(int[][] first, int[][] second) {
        int firstLevelLength = java.lang.Math.min(first.length, second.length);
        int secondFirstArrayLength = first.length > 0 ? first[0].length : 0;
        int secondSecondArrayLength = second.length > 0 ? second[0].length : 0;
        int secondLevelLength = java.lang.Math.min(secondFirstArrayLength, secondSecondArrayLength);
        int[][] result = new int[firstLevelLength][secondLevelLength];
        for (int i = 0; i < firstLevelLength; i++) {
            for (int j = 0; j < secondLevelLength; j++) {
                result[i][j] = first[i][j] + second[i][j];
            }
        }
        return result;
    }

    public static boolean isArrayPretty(int[] array) {
        if (array.length == 0) {
            return false;
        }
        boolean isPretty = true;
        for (int i = 0; i < array.length; i++) {
            boolean isCurrentElemPretty = false;
            for (int j = 0; j < array.length; j++) {
                if (isCurrentElemPretty) {
                    break;
                }
                if (array[i] == array[j] - 1 || array[i] == array[j] + 1) {
                    isCurrentElemPretty = true;
                }
            }
            if (!isCurrentElemPretty) {
                isPretty = false;
                break;
            }
        }
        return isPretty;
    }

    public static int calculateSum(Map<String, Integer> data, String keyPart) {
        int sum = 0;
        if (data.isEmpty()) {
            return 0;
        }
        if (keyPart.isEmpty()) {
            for (Map.Entry<String, Integer> entry : data.entrySet()) {
                sum += entry.getValue();
            }
        } else {
            String keyPartLowerCase = keyPart.toLowerCase();
            for (Map.Entry<String, Integer> entry : data.entrySet()) {
                int keyPartIndex = entry.getKey().toLowerCase().indexOf(keyPartLowerCase);
                sum += keyPartIndex >= 0 ? entry.getValue() : 0;
            }
        }
        return sum;
    }
}