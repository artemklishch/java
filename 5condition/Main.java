public class Main {
    public static void main(String[] args) {
        // int x = 10;
        // System.out.println(x);
        // System.out.println(1);
        // System.out.println(2);
        // System.out.println(3);

        // int x = 10;
        int x = 2;
        if (x > 5) {
            System.out.println(1);
            System.out.println(2);
            System.out.println(3);
        }
        System.out.println(x);

        System.out.println("-----");

        int age = 10;
        if (age > 18) {
            System.out.println("Adult");
        } else if (age > 7) {
            System.out.println("Child");
        } else if (age > 3) {
            System.out.println("Toddler");
        } else {
            System.out.println("Baby");
        }
    }
}