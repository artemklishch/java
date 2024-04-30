package org.example;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Optional;
import java.util.regex.Pattern;
import java.util.stream.Collector;
import java.util.stream.Collectors;

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

        System.out.println(reverseBitsToInteger(417));
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
}