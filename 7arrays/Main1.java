public class Main1 {
    public static void main(String[] args) {
        String[] names = { "Bob", "Alice", "John" };
        names[0] = "Jane";
        for (int i = 0; i < names.length; i++) {
            System.out.println("Name: " + i + " = " + names[i]);
        }

        System.out.println("------");

        int[] numbers = new int[4];
        numbers[0] = 10;
        numbers[1] = 20;
        for (int i = 0; i < numbers.length; i++) {
            System.out.println("Number: " + numbers[i]);
        }
    }

}