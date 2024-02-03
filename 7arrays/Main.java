public class Main {
    public static void main(String[] args) {
        int[] numbers = { 10, 11, 12, 13 };
        for (int i = 0; i < numbers.length; i++) {
            System.out.println("Index: " + i + " = " + numbers[i]);
        }

        System.out.println("-------");

        String[] names = { "Bob", "Alice", "John" };
        for (int i = 0; i < names.length; i++) {
            System.out.println("Name: " + i + " = " + names[i]);
        }

        System.out.println("-------");

        for (String name : names) {
            System.out.println("Name = " + name);
        }
    }

}