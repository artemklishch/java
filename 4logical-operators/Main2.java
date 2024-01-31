public class Main2 {
    public static void main(String[] args) {
        int cashInWalleet = 30;
        int cardAmount = 100;

        int price = 40;

        boolean canpayWithCard = cardAmount >= price;
        boolean hasEnoughCash = cashInWalleet >= price;
        boolean canBuy = canpayWithCard || hasEnoughCash;
        System.out.println(canBuy);
    }
}