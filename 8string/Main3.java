public class Main3 {
    public static void main(String[] args) {
        String str1 = "Hello " + "world " + 15 + false + 2.12;
        System.out.println(str1);

        System.out.println("-----");

        StringBuilder builder = new StringBuilder();
        builder.append("hi,").append(" ancle Tom!").append(" How are you!");
        String str2 = builder.toString();
        System.out.println(str2);

        StringBuilder reverse = builder.reverse();
        String str3 = reverse.toString();
        System.out.println(str3);
    }
}