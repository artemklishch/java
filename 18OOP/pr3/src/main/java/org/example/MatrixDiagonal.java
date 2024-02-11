package org.example;

public class MatrixDiagonal {
    public int[] getDiagonal(int[][] matrix) {
        int[] values = new int[matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            values[i] = matrix[i][i];
        }
        return values;
    }

    public int[] getCounterDiagonal(int[][] matrix) {
        int[] values = new int[matrix.length];
        int count = matrix.length - 1;
        for (int i = 0; i <= matrix.length - 1; i++) {
            values[i] = matrix[i][count];
            count--;
        }
        return values;
    }
}
