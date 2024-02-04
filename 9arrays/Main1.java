public class Main1 {
    public static void main(String[] args) {
        int[][][] cube = new int[10][10][10];
        int[][][][] array = new int[3][5][2][10];

        int[][] matrix = new int[][] {
                { -4, 5, 1, 10 },
                { 10, 1, 11, 70 }
        };
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.println(i + " " + j + " = " + matrix[i][j]);
            }
        }
    }

}