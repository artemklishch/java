public class Main {
    public static void main(String[] args) {
        // f(n) = C - кількість операцій не залежить від розміру вхідних даних
        // f(n) = a*n + b   - лінійна функція
        // f(n) = a*n^2 + b*n + c   - квадратична операція

        // O(1) - constant
        // O(n) - linear

        int[] array = new int[]{1, 2, 3, 4, 5};
        printArray(array);
        getPosition(array, 1);
    }


    // 2 * O(1) --> O(1)
    private static int getSum(int a, int b) {
        int sum = a + b; // O(1) константа
        System.out.println(sum); // O(1) константа
        return sum;
    }

    private static void printArray(int[] array) {
        int n = array.length;
        for (int i = 0; i < n; i++) { // O(n)
            System.out.println(array[i]);
        }
    }

    private static int getPosition(int[] array, int element) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == element) {
                return i;
            }
        }
        return -1;
    }
}
