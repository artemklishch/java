public class Main1 {
    public static void main(String[] args) {
        // int cashInWalleet = 50;
        int cashInWalleet = 30;
        int age = 25;

        int price = 40;
        int ageLimit = 18;

        boolean isAllowed = age >= ageLimit;
        boolean isEnoughMoney = cashInWalleet >= price;
        boolean canBuy = isAllowed && isEnoughMoney;
        System.out.println(canBuy);
    }
}