public class Main {
    public static void main(String[] args) {
        // int a = 5;
        // int b = 8;

        // int perimeter = 2 * a + 2 * b;
        // int square = a * b;

        // System.out.println("Rectangle " + a + " x " + b);
        // System.out.println("Perimeter is " + perimeter);
        // System.out.println("Square is " + square);
        // System.out.println("-------");

        // int a1 = 3;
        // int b1 = 10;

        // int perimeter1 = 2 * a1 + 2 * b1;
        // int square1 = a1 * b1;

        // System.out.println("Rectangle " + a1 + " x " + b1);
        // System.out.println("Perimeter is " + perimeter1);
        // System.out.println("Square is " + square1);
        // System.out.println("-------");
        printReactangeInfo(5, 8);
        printReactangeInfo(3, 10);
    }

    public static void printReactangeInfo(int a, int b) {

        int perimeter = 2 * a + 2 * b;
        int square = a * b;

        System.out.println("Rectangle " + a + " x " + b);
        System.out.println("Perimeter is " + perimeter);
        System.out.println("Square is " + square);
        System.out.println("-------");
    }
}