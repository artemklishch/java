package com.example;

public class Calculator {
    public int getSum(int a, int b) {
        return a + b;
    }

    public int getSum(int a, int b, int c) {
        return a + b + c;
    }

    public int getSum(double a, double b) {
        return (int) (a + b); // data transformation
    }

    public int getSum(int a, double b) {
        return (int) (a + b); // data transformation
    }

    public int getSum(double a, int b) {
        return (int) (a + b); // data transformation
    }
}
