public class Main {
    public static void main(String[] args) {
        System.out.println("sum");
        int sum = 10 + 5;
        System.out.println(sum);
        sum -= 7;
        System.out.println(sum);
        sum *= 2;
        System.out.println(sum);

        System.out.println("------");

        System.out.println("devide");
        int val1 = 8 / 4;
        System.out.println(val1);
        int val2 = 6 / 4; // 1 , because we define the varable with 'int' - it doesn't save decimap part
                          // of number
        System.out.println(val2);

        double val3 = 6 / 4; // 1.0, because both numbereas ate of 'int' type
        System.out.println(val3);

        int a = 6;
        double b = 4;
        double val4 = a / b;
        System.out.println(val4); // 1.5 - for correct calculating we need to have at least one number of 'double'
                                  // type
    }
}