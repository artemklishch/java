//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        sayHi(5);
    }

    private static void sayHi(int number) {
        if (number == 0) {
            System.out.println("Done");
        } else {
            System.out.println("Hi!");
            number--;
            sayHi(number);
        }
    }

    public static int powerOf10(int n) {
        int result = 1;
        for (int i = 1; i <= n; i++) {
            result *= 10;
        }
        return result;
    }

    public static int powerOf10Rec(int n) {
        if (n == 0) {
            return 1;
        }
        return powerOf10Rec(n - 1) * 10;
    }
}