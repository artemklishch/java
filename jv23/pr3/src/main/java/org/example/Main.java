package org.example;

import org.w3c.dom.ls.LSOutput;

import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.*;
import java.util.Set;
import java.util.function.IntUnaryOperator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
    private static final DecimalFormat decfor = new DecimalFormat("0.00");
    private static final String JUMPING = "Jumping!!";
    private static final String NOT = "Not!!";

    public static void main(String[] args) {
//        Object[] objects = new Object[]{3, 6};
//        Swap swap = new Swap(objects);
//        swap.swapValues();
//        System.out.println(Arrays.toString(swap.arguments));
//
//        System.out.println(Arrays.toString(RowWeights.getTotalWeight(new int[]{70, 58, 75, 34, 91})));
//
//        System.out.println(truncateToHundredth(2.655));
//        System.out.println(Integer.valueOf("26"));
//        System.out.println(hydrate("1 shot, 5 ciders and 1 glass of wine"));
//        System.out.println(repeatString(10, "Hello"));
//        System.out.println(removeVowel("HelloY"));
//        System.out.println(isValidParentheses(")()()()()(dfsgsdfg"));

//        Dictionary dictionary = new Dictionary(new String[]{"cherry", "pineapple", "melon", "strawberry", "raspberry"});
//        System.out.println(dictionary.findMostSimilar("strawbery"));
//        Dictionary dictionary = new Dictionary(new String[]{"stars", "mars", "wars", "codec", "codewars"});
//        System.out.println(dictionary.findMostSimilar("coddwars"));
//        Dictionary dictionary = new Dictionary(new String[]{"javascript", "java", "ruby", "php", "python", "coffeescript"});
//        System.out.println(dictionary.findMostSimilar("heaven"));
//        System.out.println(dictionary.findMostSimilar("javascript"));

//        System.out.println(isJumping(11));
//        System.out.println(breakChocolate(4,1));

//        System.out.println(convertToCamelCase("books-already-read"));
//        System.out.println(convertToCamelCase("Long_function_Name"));

//        System.out.println(whoLikesIt(new String[]{"Peter"}));
//        System.out.println(whoLikesIt(new String[]{"Jacob", "Alex"}));
//        System.out.println(whoLikesIt(new String[]{"Max", "John", "Mark"}));
//        System.out.println(whoLikesIt(new String[]{"Alex", "Jacob", "Mark", "Max"}));
//        System.out.println(whoLikesIt(new String[]{}));

//        System.out.println(reverseBitsToInteger(417));

//        System.out.println(NextBiggerNumber.getNextBiggerNumber(534976));
//        System.out.println(NextBiggerNumber.getNextBiggerNumber(17));
//        System.out.println(NextBiggerNumber.getNextBiggerNumber(528));
//        System.out.println(NextBiggerNumber.getNextBiggerNumber(6008));
//        System.out.println(NextBiggerNumber.getNextBiggerNumber(2));
//        System.out.println(NextBiggerNumber.getNextBiggerNumber(33));
//        System.out.println(NextBiggerNumber.getNextBiggerNumber(975));
//        System.out.println(NextBiggerNumber.getNextBiggerNumber(20550));
//        System.out.println(NextBiggerNumber.getNextBiggerNumber(1283331765));
//        System.out.println(NextBiggerNumber.getNextBiggerNumber(514));
//        System.out.println(NextBiggerNumber.getNextBiggerNumber(377));
//        System.out.println(NextBiggerNumber.getNextBiggerNumber(992575701));

//        System.out.println(IPAddresses.countIPBetween("10.0.0.0", "10.0.0.50")); // Output: 50
//        System.out.println(IPAddresses.countIPBetween("10.0.0.0", "10.0.1.0"));  // Output: 256
//        System.out.println(IPAddresses.countIPBetween("20.0.0.10", "20.0.1.0")); // Output: 246

//        int[][] m = new int[][]{
//                {-2, 31, 6, 7},
//                {15, -42, 1, 0},
//                {9, -7, 12, 19},
//        };
//        System.out.println(m.length);

//        System.out.println(makeSentence(new String[]{"mate", "academy"}));

//        System.out.println(getMaxNumber(213));

//        System.out.println(replaceDots("one.two.three"));

//        System.out.println(highAndLow("1 2 3 4 5"));

//        System.out.println(getMinValue(new int[]{6, 7, 8, 7, 6, 6}));

//        System.out.println(reverseWords("Reverse these words"));

//        System.out.println(breakCamelCase("camelCasingFoo"));

//        System.out.println(isDisarium(135));

//        System.out.println(isSubstring("Something", "Home"));

//        System.out.println(calculateTotalTime(new int[]{5, 3, 4}, 1)); // 12
//        System.out.println(calculateTotalTime(new int[]{5, 3, 4}, 3)); // 5
//        System.out.println(calculateTotalTime(new int[]{10, 2, 3, 3}, 2)); // 10
//        System.out.println(calculateTotalTime(new int[]{2, 3, 10}, 2)); // 12
//        System.out.println(calculateTotalTime(new int[]{2, 3, 10, 6, 3, 14}, 2)); // 26

//        System.out.println(isPangram("abcdeijklmnopqrstuvwxyz"));
//        System.out.println(isPangram("Sphinx of black quartz, judge my vow."));
//        System.out.println(isPangram("Pack My Box With Five Dozen Liquor Jugs"));

//        System.out.println(detectAutomorphic(1));
//        System.out.println(detectAutomorphic(13));
//        System.out.println(detectAutomorphic(76));
//        System.out.println(detectAutomorphic(25));

//        System.out.println(6<<2);

//        System.out.println(getWinnerWord("alphabet"));
//        System.out.println(getWinnerWord("i need a taxi"));
//        System.out.println(getWinnerWord("a bb aaaa ca d"));

//        System.out.println(Arrays.toString(getMultiples(2, 10)));

//        System.out.println(extractFileName("1231231223123131_FILE_NAME.EXTENSION.OTHEREXTENSION"));

//        System.out.println(Arrays.toString(capitalizeNames(new String[]{"MARIA"})));

//        System.out.println(sortGiftCode("pqksuvy"));

//        System.out.println(Arrays.toString(toReversedArray(14)));

//        System.out.println(isSpecialNumber(0));

//        System.out.println(Integer.toBinaryString(1));
//        System.out.println(Integer.toBinaryString(2));
//        System.out.println(Integer.toBinaryString(3));
//        System.out.println(Integer.toBinaryString(4));
//        System.out.println(Integer.toBinaryString(5));
        System.out.println(Arrays.toString(getExtraPerfectNumbers(3)));
        System.out.println(Arrays.toString(getExtraPerfectNumbers(7)));
    }

    public static double roundToHundredth(double num) {
        BigDecimal number = new BigDecimal(num);
        return (number.setScale(2, RoundingMode.HALF_EVEN)).doubleValue();
    }

    public static double truncateToHundredth(double num) {
//        BigDecimal number = new BigDecimal(num);
//        return (number.setScale(2, RoundingMode.DOWN)).doubleValue();
        return Double.parseDouble(decfor.format(num));
    }

    public static String hydrate(String drinks) {
        int glassesNumber = Arrays.stream(drinks.split(" "))
                .filter(sub -> {
                    try {
                        Integer.parseInt(sub);
                    } catch (NumberFormatException e) {
                        return false;
                    }
                    return true;
                })
                .map(Integer::parseInt)
                .reduce(0, Integer::sum);
        return glassesNumber + (glassesNumber == 1 ? " glass of water" : " glasses of water");
    }

    public static int getAverageMark(int[] marks) {
        return Arrays.stream(marks)
                .reduce(0, Integer::sum) / marks.length;
    }

    public static String repeatString(int times, String string) {
//        StringBuilder stringBuilder = new StringBuilder();
//        for (int i = 0; i < times; i++) {
//            stringBuilder.append(string);
//        }
//        return stringBuilder.toString();
//        return String.valueOf(string).repeat(Math.max(0, times));
        return String.valueOf(string).repeat(times);
    }

    public static String removeVowel(String string) {
        return string.replaceAll("[AEIOUaeiou]", "");
    }

    public static boolean isValidParentheses(String string) {
        String openBreckets = string.replaceAll("[^(]", "");
        String closeBreckets = string.replaceAll("[^)]", "");
        if (openBreckets.length() != closeBreckets.length()) {
            return false;
        }
        int firstOpenBrecketIndex = string.indexOf("(");
        int firstCloseBrecketIndex = string.indexOf(")");
        if (firstOpenBrecketIndex > firstCloseBrecketIndex) {
            return false;
        }
        int lastOpenBrecketIndex = string.lastIndexOf("(");
        int lastCloseBrecketIndex = string.lastIndexOf(")");
        if (lastOpenBrecketIndex > lastCloseBrecketIndex) {
            return false;
        }
        return true;
    }

    public static String isJumping(int number) {
        String[] stringNumbers = (number + "").split("");
        if (stringNumbers.length == 1) {
            return JUMPING;
        }
        for (int i = 0; i < stringNumbers.length; i++) {
            if (i == stringNumbers.length - 1) {
                break;
            }
            if (Math.abs(Integer.parseInt(stringNumbers[i + 1]) - Integer.parseInt(stringNumbers[i])) > 1 || Integer.parseInt(stringNumbers[i + 1]) - Integer.parseInt(stringNumbers[i]) == 0) {
                return NOT;
            }
        }
        return JUMPING;
    }

    public static int breakChocolate(int n, int m) {
//        if (n == 0 || m == 0) {
//            return 0;
//        }
//        return n * m - 1;
        return n == 0 || m == 0 ? 0 : n * m - 1;
    }

    public static String convertToCamelCase(String string) {
        String[] names = string.split("[_-]");
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < names.length; i++) {
            if (i == 0) {
                stringBuilder.append(names[i]);
            } else {
                stringBuilder.append(names[i].substring(0, 1).toUpperCase()).append(names[i].substring(1));
            }
        }
        return stringBuilder.toString();
    }

    public static String whoLikesIt(String[] names) {
        String multipleLikeThis = " like this";
        String singleLikeThis = " likes this";
        if (names.length == 0) {
            return "No one likes this";
        } else if (names.length == 1) {
            return names[0] + singleLikeThis;
        } else if (names.length == 2) {
            return names[0] + " and " + names[1] + multipleLikeThis;
        } else if (names.length == 3) {
            return names[0] + ", " + names[1] + " and " + names[2] + multipleLikeThis;
        } else {
            return names[0] + ", " + names[1] + " and " + (names.length - 2) + " others" + multipleLikeThis;
        }
    }

    public static int reverseBitsToInteger(int number) {
//        return Integer.parseInt(
//                String.join(
//                        "",
//                        Arrays.stream(Integer.toBinaryString(number).split(""))
//                                .collect(Collectors.toList())
//                                .reversed()
//                ),
//                2
//        );
        String reversedBinary = new StringBuilder(Integer.toBinaryString(number)).reverse().toString();
        return Integer.parseInt(reversedBinary, 2);
    }

    public static int countPoints(String[] games) {
        int estimation = 0;
        for (String score : games) {
            String[] values = score.split(":");
            int ourScore = Integer.parseInt(values[0]);
            int otherScore = Integer.parseInt(values[1]);
            if (ourScore > otherScore) {
                estimation += 3;
            } else if (ourScore == otherScore) {
                estimation += 1;
            }
        }
        return estimation;
    }

    public static int[][] addSquareMatrices(int[][] a, int[][] b) {
        int firstLevelLength = java.lang.Math.min(a.length, b.length);
        int secondFirstArrayLength = a.length > 0 ? a[0].length : 0;
        int secondSecondArrayLength = b.length > 0 ? b[0].length : 0;
        int secondLevelLength = java.lang.Math.min(secondFirstArrayLength, secondSecondArrayLength);
        int[][] result = new int[firstLevelLength][secondLevelLength];
        for (int i = 0; i < firstLevelLength; i++) {
            for (int j = 0; j < secondLevelLength; j++) {
                result[i][j] = a[i][j] + b[i][j];
            }
        }
        return result;
    }

    public static String stringify(int size) {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < size; i++) {
            if (i % 2 == 0) {
                res.append(1);
            } else {
                res.append(0);
            }
        }
        return res.toString();
    }

    public static int multiplyNumber(int num) {
        if (num % 2 == 0) {
            return num * 8;
        } else {
            return num * 9;
        }
    }

    public static String makeSentence(String[] words) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < words.length; i++) {
            if (i == 0) {
                stringBuilder.append(words[i]);
            } else {
                stringBuilder.append(" ").append(words[i]);
            }
        }
        return stringBuilder.toString();
    }

    public static String findNeedle(Object[] haystack) {
        for (int i = 0; i < haystack.length; i++) {
            if (haystack[i] != null && haystack[i].equals("needle")) {
                return "found the needle at position " + i;
            }
        }
        return null;
    }

    public static long getMaxNumber(long num) {
        String numbers = Arrays.stream(String.valueOf(num).split(""))
                .map(Integer::parseInt)
                .sorted((a, b) -> b - a)
                .map(String::valueOf)
                .collect(Collectors.joining());
        return Long.parseLong(numbers);
    }

    ;

    public static String replaceDots(final String str) {
        return str.replaceAll("\\.", "-");
    }

    public static String highAndLow(String numbers) {
        Integer maxNum = Arrays.stream(numbers.split(" "))
                .map(Integer::parseInt)
                .max(Integer::compare).get();
        Integer minNum = Arrays.stream(numbers.split(" "))
                .map(Integer::parseInt)
                .min(Integer::compare).get();
        return maxNum + " " + minNum;
    }

    public static int getMinValue(int[] nums) {
        String number = Arrays.stream(nums)
                .boxed()
                .collect(Collectors.toSet())
                .stream()
                .map(String::valueOf)
                .collect(Collectors.joining());
        return Integer.parseInt(number);
    }

    public static String reverseWords(final String string) {
        if (string.replaceAll(" ", "").isEmpty()) {
            return string;
        }
        return Arrays.stream(string.split(" "))
                .map(v -> new StringBuilder().append(v).reverse())
                .collect(Collectors.joining(" "));
    }

    public static Integer calculateTip(double amount, String rating) {
        String ratingToCompare = rating.toLowerCase();
        switch (ratingToCompare) {
            case "terrible":
                return (int) Math.ceil(amount * 0);
            case "poor":
                return (int) Math.ceil(amount * 0.05);
            case "good":
                return (int) Math.ceil(amount * 0.1);
            case "great":
                return (int) Math.ceil(amount * 0.15);
            case "excellent":
                return (int) Math.ceil(amount * 0.2);
            default:
                return null;
        }
//        String ratingToCompare = rating.toLowerCase();
//        return switch (ratingToCompare) {
//            case "terrible" -> (int) Math.ceil(amount * 0);
//            case "poor" -> (int) Math.ceil(amount * 0.05);
//            case "good" -> (int) Math.ceil(amount * 0.1);
//            case "great" -> (int) Math.ceil(amount * 0.15);
//            case "excellent" -> (int) Math.ceil(amount * 0.2);
//            default -> null;
//        };
    }

    public static int getSumOfElements(int[][] matrix) {
        int sum = 0;
        for (int[] array : matrix) {
            for (int number : array) {
                sum += number;
            }
        }
        return sum;
    }

    public static int countOccurrences(String string, char letter) {
        int number = 0;
        String comparingLetter = String.valueOf(letter);
        for (String strLetter : string.split("")) {
            if (strLetter.equals(comparingLetter)) {
                number++;
            }
        }
        return number;
    }

    public static String breakCamelCase(String input) {
        if (input.isEmpty()) {
            return input;
        }
        String[] comparingLettersArray = input.toUpperCase().split("");
        String[] lettersArray = input.split("");
        List<String> subStrings = new ArrayList<>();
        int startIndex = 0;
        for (int i = 0; i < comparingLettersArray.length; i++) {
            if (comparingLettersArray[i].equals(lettersArray[i])) {
                subStrings.add(input.substring(startIndex, i));
                startIndex = i;
            }
        }
        subStrings.add(input.substring(startIndex));
        return String.join(" ", subStrings);
    }

    public static boolean isDisarium(int number) {
        String[] numberSymbols = String.valueOf(number).split("");
        double sum = IntStream.range(0, numberSymbols.length)
                .mapToDouble(i -> Math.pow(Integer.parseInt(numberSymbols[i]), i + 1))
                .reduce(0, Double::sum);
        return sum == number;
    }

    public static boolean isSubstring(String word1, String word2) {
        String[] word1Letters = word1.toLowerCase().split("");
        String word2ToCompare = word2.toLowerCase();
        for (int i = 0; i < word1Letters.length; i++) {
            boolean isSubstring = false;
            if (i + 1 < word1Letters.length) {
                String subStr = word1Letters[i] + word1Letters[i + 1];
                isSubstring = word2ToCompare.contains(subStr);
            }
            if (isSubstring) {
                return true;
            }
        }
        return false;
    }

    public static int calculateTotalTime(int[] customers, int checkout) {
        if (customers.length == 0) {
            return 0;
        }
        if (customers.length <= checkout) {
            return Arrays.stream(customers).max().getAsInt();
        }
        if (checkout == 1) {
            return Arrays.stream(customers).reduce(0, Integer::sum);
        }
        int[] firstSubArray = Arrays.copyOfRange(customers, 0, checkout);
        int time = 0;
        for (int i = checkout; i < customers.length; i++) {
            int min = Arrays.stream(firstSubArray).min().getAsInt();
            time += min;
            int minValueIndex = 0;
            for (int j = 0; j < firstSubArray.length; j++) {
                if (firstSubArray[j] == min) {
                    minValueIndex = j;
                    break;
                }
            }
            firstSubArray = Arrays.stream(firstSubArray).map(v -> v - min).toArray();
            if (i + 1 < customers.length) {
                firstSubArray[minValueIndex] = customers[i];
            } else {
                firstSubArray[minValueIndex] = customers[i];
                time += Arrays.stream(firstSubArray).max().getAsInt();
            }
        }
        return time;
    }

    public static boolean isPangram(String sentence) {
        final String ABCLetters = "abcdefghijklmnopqrstuvwxyz";
        List<String> letters = List.of(ABCLetters.split(""));
//        if (sentence.isEmpty()) {
//            return false;
//        }
//        Set<String> uniqueLetters = Arrays.stream(sentence.toLowerCase().split(""))
//                .filter(s -> Character.isLetter(s.charAt(0)))
//                .collect(Collectors.toSet());
//        return uniqueLetters.size() == ABCLetters.length();
        List<String> collect = Arrays.stream(sentence.toLowerCase().split(""))
                .filter(s -> Character.isLetter(s.charAt(0)))
                .toList();
        for (String letter : letters) {
            if (!collect.contains(letter)) {
                return false;
            }
        }
        return true;
    }

    public static String detectAutomorphic(int number) {
        String automorphic = "Automorphic";
        String not = "Not!!";
        String strFromNumber = String.valueOf(number);
        String pow = String.valueOf(number * number);
        if (strFromNumber.length() == pow.length()) {
            return strFromNumber.equals(pow) ? automorphic : not;
        } else {
            String lastSymbols = pow.substring(pow.length() - strFromNumber.length());
            return lastSymbols.equals(strFromNumber) ? automorphic : not;
        }
    }

    public static String getWinnerWord(String words) {
        if (words.isEmpty()) {
            return "";
        }
        String[] abcLetters = "abcdefghijklmnopqrstuvwxyz".split("");
        Map<String, Integer> letterValues = new HashMap<>();
                IntStream.range(0, abcLetters.length)
                .forEach(i -> letterValues.put(abcLetters[i], i + 1));
        String[] wordsArray = words.split(" ");
        String result = "";
        int wordCost = 0;
        for (int i = 0; i < wordsArray.length; i++) {
            String[] wordLetters = wordsArray[i].toLowerCase().split("");
            int cost = 0;
            for (int j = 0; j < wordLetters.length; j++) {
                int letterValue = letterValues.get(wordLetters[j]);
                cost += letterValue;
            }
            if (cost > wordCost) {
                wordCost = cost;
                result = wordsArray[i];
            }
        }
        return result;
    }

    public static int[] getMultiples(int multiples, int number) {
        int[] res = new int[multiples];
        for (int i = 0; i < res.length; i++) {
            res[i] = (i + 1) * number;
        }
        return res;
    }

    public static String extractFileName(String dirtyFileName) {
        int undescoreIndex = dirtyFileName.indexOf("_");
        String noDateName = dirtyFileName.substring(undescoreIndex + 1);
        String[] noDateParts = noDateName.split("\\.");
        return noDateParts[0] + "." + noDateParts[1];
    }

    public static String toAlternativeCase(String string) {
        String[] stringArray = string.split("");
        String[] upperCaseStringArray = string.toUpperCase().split("");
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < stringArray.length; i++) {
            if (stringArray[i].equals(upperCaseStringArray[i])) {
                stringBuilder.append(stringArray[i].toLowerCase());
            } else {
                stringBuilder.append(stringArray[i].toUpperCase());
            }
        }
        return stringBuilder.toString();
    }

    public static String[] capitalizeNames(String[] names) {
        return Arrays.stream(names)
                .map(n -> {
                    String lowerCaseName = n.toLowerCase();
                    return lowerCaseName.substring(0,1).toUpperCase() + lowerCaseName.substring(1);
                }).toArray(String[]::new);
    }

    public static String sortGiftCode(String code) {
        return Arrays.stream(code.split(""))
                .sorted()
                .collect(Collectors.joining());
    }

    public static int[] toReversedArray(long number) {
        String[] numbers = new StringBuilder().append(number).reverse().toString().split("");
        int[] array = new int[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            array[i] = Integer.parseInt(numbers[i]);
        }
        return array;
    }

    public static String isSpecialNumber(int number) {
        Integer[] specialNumbers = new Integer[]{0,1,2,3,4,5};
        List<Integer> list = Arrays.asList(specialNumbers);
        String[] numberSymbols = String.valueOf(number).split("");
        for (int i = 0; i < numberSymbols.length; i++) {
            if (!list.contains(Integer.parseInt(numberSymbols[i]))) {
                return "NOT!!";
            }
        }
        return "Special!!";
    }

    public static IntUnaryOperator add(int n) {
        return a -> n + a;
    }

    public static int findShortest(String string) {
        int length = string.length();
        String[] words = string.split(" ");
        for (String word : words) {
            int wordLength = word.length();
            if (wordLength < length) {
                length = wordLength;
            }
        }
        return length;
    }

    public static int[] getExtraPerfectNumbers(int number) {
        List<Integer> numbers = new ArrayList<>();
        for (int i = 1; i <= number; i++) {
            String binaryNumber = Integer.toBinaryString(i);
            if (binaryNumber.substring(0,1).equals(binaryNumber.substring(binaryNumber.length() - 1))) {
                numbers.add(i);
            }
        }
        return numbers.stream().mapToInt(Integer::intValue).toArray();
    }
}