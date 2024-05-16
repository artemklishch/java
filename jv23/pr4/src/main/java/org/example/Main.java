package org.example;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
//        System.out.println(toSimplePigLatin("Java is fun"));
//        System.out.println(DoubleCola.getNthPerson(new String[]{"Alice", "Bob", "Charlie", "David"}, 111));
//        System.out.println(DoubleCola.getNthPerson(new String[]{"Arthur", "Merlin", "Morgana", "Guinevere"}, 239483859));
//        String str = "Arthur";
//        char[] chars = str.toCharArray();
//        System.out.println(chars);
//        System.out.println(new String(chars));
    }

    public static String toSimplePigLatin(String string) {
        return Arrays.stream(string.split(" "))
                .map(Main::updateString)
                .collect(Collectors.joining(" "));
    }

    public static String updateString(String string) {
        if (!Character.isLetter(string.charAt(0))) {
            return string;
        }
        StringBuilder stringBuilder = new StringBuilder();
        String firstLetter = string.substring(0, 1);
        String mainStringPart = string.substring(1);
        stringBuilder.append(mainStringPart).append(firstLetter).append("ay");
        return stringBuilder.toString();
    }
}