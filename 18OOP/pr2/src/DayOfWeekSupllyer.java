
import java.util.Random;

public class DayOfWeekSupllyer {
    public DayOfWeek getRandomDayOfWeek() {
        int index = new Random().nextInt(DayOfWeek.values().length);
        return DayOfWeek.values()[index];
    }
}
