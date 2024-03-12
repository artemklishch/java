import java.util.Map;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        // resize; capacity, load factor, threshold
        // resize happens on put() method call
        Map<Integer, String> flats = new HashMap<>();

        flats.put(17, "John"); // 17 % 16 = 1
        flats.put(8, "Bob"); // 8 % 16 = 8
        flats.put(3, "Alice"); // 3 % 16 = 3
        flats.put(35, "Tanya"); // 35 % 16 = 3
        flats.put(56, "Bohdan"); // 56 % 16 = 8
        flats.put(62, "Artem"); // 62 % 16 = 14
        flats.put(77, "Roman"); // 77 % 16 = 13
        flats.put(89, "Anna"); // 89 % 16 = 9
        flats.put(91, "Sofia"); // 91 % 16 = 11

        flats.put(105, "Kate"); // 17 % 16 = 9    106 % 16 = 9
        flats.put(119, "Dima"); // 17 % 16 = 7    119 % 16 = 7
        flats.put(121, "Ksenia"); // 17 % 16 = 9  121 % 16 = 9
        flats.put(137, "Oleg"); // 17 % 16 = 9    137 % 16 = 9
    }
}