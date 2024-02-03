public class Main1 {
    public static void main(String[] args) {
        String str = "1";
        System.out.println(str.length());

        String s = "a";
        boolean isEmpty = s.isEmpty();
        System.out.println(isEmpty);

        System.out.println("----");

        String str1 = "hello world";
        String substring1 = str1.substring(4);
        System.out.println(substring1);
        System.out.println(str1.substring(4, 8));
    }

}