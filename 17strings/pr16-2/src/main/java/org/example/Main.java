package org.example;

import java.util.Arrays;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        main.matchResult(1, 2, 3, 4);

        String[] plans = new String[]{"wake up", "have breakfast", "go to work", "solve 5 tasks from codewars"};

        System.out.println(createDailyPlan(plans));


        int a = 10;
        int b = 6;
        int c = a | b;
        int c1 = a & b;
        int c2 = a ^ b;
        int c3 = ~a;
        System.out.println(c);
        System.out.println(c1);
        System.out.println(c2);
        System.out.println(c3);

        int[] nums = {0, 2, 3, 4};
        String val = new String(Arrays.toString(nums));
        StringBuilder builder = new StringBuilder(10);
        System.out.println(builder.toString().length());

        main.toBinaryString(25);

    }

    public int matchResult(int result1, int result2, int bet1, int bet2) {
        //Write code below this line
        boolean fullGuess = result1 == bet1 && result2 == bet2;
        boolean partialGuess = (bet1 > bet2 && result1 > result2) || (bet1 < bet2 && result1 < result2) || (bet1 == bet2 && result1 == result2);

        return fullGuess ? 2 : partialGuess ? 1 : 0;
        //Write code above this line
    }

    public static String createDailyPlan(String[] plans) {
        //Write code below this line
        StringBuilder builder = new StringBuilder();
        builder.append("My plans:").append("\n");
        for (int i = 0; i < plans.length; i++) {
            builder.append(i + 1).append(".)").append(" ").append(plans[i]).append(";");
            if (i + 1 < plans.length) {
                builder.append("\n");
            }
        }
        return builder.toString();
        //Write code above this line
    }

    public boolean booleanExpression(boolean a, boolean b, boolean c, boolean d) {
        //write code below this line
        boolean allTrue = a && b && c && d;
        boolean oneFalse = (a && b && c && !d) || (a && b && !c && d) || (a && !b && c && d) || (!a && b && c && d);
        boolean possibleValues = (a && b) || (a && c) || (a && d) || (b && c) || (b && d) || (c && d);
        return possibleValues && !allTrue && !oneFalse;
        //write code above this line
    }

    public String toBinaryString(int value) {
        //Write code below this line
        StringBuilder builder = new StringBuilder();
        double valueForLoop = (double) value;
        int count = Integer.SIZE;
        while (count > 0) {
            boolean isCalculatedValue = valueForLoop >= 0;
            if (!isCalculatedValue) {
                builder.append("0");
            } else if (valueForLoop % 2 == 0) {
                builder.append("0");
            } else {
                builder.append("1");
            }
            valueForLoop = (int) valueForLoop / 2;
            count--;
        }
        String str = builder.reverse().toString();
        System.out.println(str);
        return str;
        //Write code above this line
    }


}