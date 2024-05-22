package org.example;

public class Main {
    private static final float LITERS_PER_GALON = 4.54609188f;
    private static final float KILOMETERS_PER_MILE = 1.609344F;

    public static void main(String[] args) {
//        System.out.println(toKiloPerLiter(10));
//        System.out.println(countDivisors(4));
    }

    public static float toKiloPerLiter(float mpg) {
        float kilos = mpg *  KILOMETERS_PER_MILE;
        return (float) Math.round((kilos / LITERS_PER_GALON) * 100) / 100;
    }

    public static int countDivisors(int number) {
        int divisorNumber = 0;
        for (int i = 1; i <= number; i++) {
            if (number % i == 0) {
                divisorNumber++;
            }
        }
        return divisorNumber;
    }
}