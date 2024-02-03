import java.util.Arrays;

public class Main4 {
    public static void main(String[] args) {
        String a = "a";
        // String b = "a"; // true
        String b = new String("a");
        System.out.println(a == b); // false
        System.out.println(a.equals(b)); // true

        System.out.println("------");

        int[] numbers = { 1, 2, 4, 8, 16 };
        System.out.println(numbers); // not understandable format
        String content = Arrays.toString(numbers);
        System.out.println(content);

        System.out.println(Arrays.toString("con tent".split(" ")));
    }
}