public class Main {
    public static void main(String[] args) {
        // int myAge = 0;
        // myAge = myAge + 1;
        // System.out.println("Happy birthday! " + myAge);
        for (int myAge = 0; myAge <= 5; myAge++) {
            System.out.println("Happy birthday! " + myAge);
        }
        System.out.println("Loop is over");
        System.out.println("----");

        int n = 1234;
        int count = 0;
        while (n % 2 == 0) {
            n = n / 2;
            System.out.println(n);
            count++;
        }
        System.out.println(count);
        System.out.println("----");

        double n1 = 123;
        int count1 = 0;
        do {
            n1 = n1 / 2;
            System.out.println(n1);
            count1++;
        } while (n1 % 2 == 0);
        System.out.println(count1);
        System.out.println("----");

        int i = 0;
        while (true) {
            i++;
            System.out.println(i);
            if (i >= 3) {
                break;
            }
        }
        System.out.println("----");

        for (int it = 0; it < 10; it++) {
            if (it % 2 != 0) {
                continue;
            }
            System.out.println(it);
        }
    }

}