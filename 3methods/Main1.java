public class Main1 {
    public static void main(String[] args) {
        String smallHouse = buildHouse(2, "red");
        String bigHouse = buildHouse(9, "blue");

        System.out.println(smallHouse);
        System.out.println(bigHouse);

        boolean isNumberEven = isEven(4);
        System.out.println(isNumberEven);

        sayHello();

        int result = sum(10, 20);
        System.out.println(result);
    }

    public static String buildHouse(int numberOfFloors, String color) {
        return numberOfFloors + "-floors building of " + color + " color.";
    }

    public static boolean isEven(int number) {
        return number % 2 == 0;
    }

    public static void sayHello() {
        System.out.println("Hello, Mates!");
    }

    public static int sum(int firstNumber, int secodNumber) {
        return firstNumber + secodNumber;
    }
}