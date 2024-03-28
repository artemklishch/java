package org.example;

import java.util.function.Function;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.DoubleFunction;
import java.util.Random;
import java.util.function.Supplier;

public class Main {
    private static final String[] COLORS = {"red", "green", "blue", "yellow", "pink",
            "black", "white"};

    public static void main(String[] args) {
//        Function<String[], String> getRandomColor = new Function<String[], String>() {
//            @Override
//            public String apply(String[] colors) {
//                return colors[new Random().nextInt(COLORS.length)];
//            }
//
//            ;
//        };
//
//        System.out.println(getRandomColor.apply(COLORS));

        Supplier<String> getRandomColor = new Supplier<String>() {
            @Override
            public String get () {
                return COLORS[new Random().nextInt(COLORS.length)];
            };
        };
        System.out.println(getRandomColor.get());

        BiFunction<Integer, Integer, Integer> getDifference = new BiFunction<Integer, Integer, Integer>(){
            @Override
            public Integer apply(Integer integer, Integer integer2) {
                return Math.abs(integer - integer2);
            }
        };

        BiFunction<Integer, Integer, Integer> getDifference2 = (integer, integer2) -> integer - integer2;

        BinaryOperator<Integer> getDifference3 = new BinaryOperator<Integer>(){
            @Override
            public Integer apply(Integer integer, Integer integer2) {
                return Math.abs(integer - integer2);
            }
        };


        System.out.println(getDifference.apply(2,5));

        System.out.println(getDifference3.apply(5,1));
    }
}