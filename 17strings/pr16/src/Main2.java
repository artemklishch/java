public class Main2 {
    public static void main(String[] args) {
        System.out.println("Start...");
//        String result = "";
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < 500000; i++) {
//            result = result + i + " ";
            result.append(i).append(" ");
        }
        System.out.println(result);
    }
}