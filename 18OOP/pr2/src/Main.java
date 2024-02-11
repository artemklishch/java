//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.util.Arrays;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Season spring = Season.SPRING;
        System.out.println(spring);

        Season[] values = Season.values();
        System.out.println(Arrays.toString(values));

        Random random = new Random();
//        int value = random.nextInt();
        int value = random.nextInt(100);
        System.out.println(value);

        DayOfWeekSupllyer supllyer = new DayOfWeekSupllyer();
        System.out.println(supllyer.getRandomDayOfWeek());
    }
}