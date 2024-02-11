package org.example;

import java.util.Arrays;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        MatrixDiagonal matrix = new MatrixDiagonal();
        final int[][] TEST_MATRIX = {
                {-2, 31, 6, 7},
                {15, -42, 1, 0},
                {9, -7, 12, 19},
                {55, 34, 1, -10}
        };
        System.out.println(Arrays.toString(matrix.getDiagonal(TEST_MATRIX)));
        System.out.println(Arrays.toString(matrix.getCounterDiagonal(TEST_MATRIX)));
    }
}