public class Main1 {
    public static void main(String[] args) {
        // integer pool: -128 ... 127
        Integer boxLength = 200;
        Integer giftLength = 200;

        System.out.println(boxLength == giftLength); // 200 or 128 - false, 20 or 127 - true
        System.out.println(boxLength.equals(giftLength)); // 200 - true

        // final key word
        // final class - impossible inheritance
        // final array or field - impossible reassign value
        // final method - impossible to redefine the method
    }
}