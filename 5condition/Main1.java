public class Main1 {
    public static void main(String[] args) {
        int shortTermCost = 50; // days q-3
        int weekCost = 40; // days 4 - 7
        int longTernCost = 30; // 8-...

        int twoDayCost = getRentalPrice(2);
        int fiveDayCost = getRentalPrice(5);
        int tenDayCost = getRentalPrice(10);

        System.out.println(twoDayCost);
        System.out.println(fiveDayCost);
        System.out.println(tenDayCost);
    }

    public static int getRentalPrice(int numberOfDays) {
        if (numberOfDays <= 3) {
            return numberOfDays * 50;
        }
        int daysLeft = numberOfDays - 3;
        if (daysLeft <= 4) {
            return 3 * 50 + daysLeft * 40;
        }
        daysLeft = numberOfDays - 7;
        return 3 * 50 + 4 * 40 + daysLeft * 30;
    }
}