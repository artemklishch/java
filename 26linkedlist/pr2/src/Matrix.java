public class Matrix {
    public static void main(String[] args) {
        int[][] first = new int[][]{{1}};
        int[][] second = new int[][]{{1, 2}, {3, 4}};
        int[][] third = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};


        printMatrix(first);
    }

    // O(n^2) - quadratic
    private static void printMatrix(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n; i++) {  // O(n)
            for (int j = 0; j < n; j++) { // O(n)
                System.out.println(matrix[i][j]); // O(1)
            }
        }
    }
}
