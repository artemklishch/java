import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[][] matrix = new int[2][4];
        String[][] cinema = new String[2][4];
        cinema[0][0] = "Bob";
        cinema[0][1] = "Alice";
        cinema[1][1] = "Olga";
        cinema[1][2] = "John";
        System.out.println(Arrays.toString(matrix));
        System.out.println(cinema[0][0]);
    }

}