//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    private int iteratingNumber;

    public static void main(String[] args) {
        System.out.println(getFactorial(6));
        System.out.println(getFibonacciNumber(10));
    }

    public static int getFactorial(int number) {
        if (number == 0) {
            return 1;
        }
        return getFactorial(number - 1) * number;
    }

    public static int getFibonacciNumber(int n) {
//        if (n <= 1) {
//            return n;
//        }
//
//        int prev = 0;
//        int curr = 1;
//
//        for (int i = 2; i <= n; i++) {
//            int next = prev + curr;
//            prev = curr;
//            curr = next;
//        }
//
//        return curr;
        if (n <= 1) {
            return n;
        }
        return getFibonacciNumber(n - 1) + getFibonacciNumber(n - 2);
    }
}