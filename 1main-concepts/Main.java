public class Main {
    public static void main(String[] args) {
        // comment
        // System.out.println("Hello worl");
        int cash = 20;

        int cookiePrice = 8;

        int candyPrice = 7;

        int totalPrice = cookiePrice + candyPrice;

        if (cash > totalPrice) {
            System.out.println("You can by cooky and candy");
        } else {
            System.out.println("Not enough money");
        }
    }
}