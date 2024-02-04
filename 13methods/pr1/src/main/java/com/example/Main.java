package com.example;

public class Main {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        int sum = calculator.getSum(10, 15);
        System.out.println("Hello world! " + sum);

        int sum2 = calculator.getSum(2, 2, 2);
        System.out.println("Hello world! " + sum2);

        int sum3 = calculator.getSum(1.1, 1.2);
        System.out.println("Hello world! " + sum3);

        // User user = new User();
        // System.out.println(user.age);
        // user.age = 18;
        // System.out.println(user.age);

        // User user2 = new User();
        // System.out.println(user2.age);

        System.out.println(User.age);

        Calc calc = new Calc(10, 10);
        int sum4 = calc.getSum();
        int sum5 = StaticCalc.getSum(3, 5);
        System.out.println(sum4);
        System.out.println(sum5);

        int value = Integer.parseInt("15");
    }
}