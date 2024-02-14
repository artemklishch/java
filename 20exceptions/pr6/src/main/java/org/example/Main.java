package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        print();
    }

    private static void print() {
        String[] data = {"hello", "world"};
        System.out.println(getMessage(data));
        String[] emptyData = {};
        System.out.println(getMessage(emptyData));
    }

    private static String getMessage(String[] data) {
        return getConcatenatedWords(data);
    }

    private static String getConcatenatedWords(String[] words) {
        StringBuilder builder = new StringBuilder();
        for (String word : words) {
            builder.append(word).append(" - ");
        }
        String message = builder.toString();
        String trimmed = message.substring(0, message.length() - 3);
        return trimmed;
    }


}