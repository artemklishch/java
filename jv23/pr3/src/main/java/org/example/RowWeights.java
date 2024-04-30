package org.example;

import java.lang.reflect.Array;

public class RowWeights {
    public static int[] getTotalWeight(int[] weights) {
        int teamOneWeight = 0;
        int teamTwoWeight = 0;
        for (int i = 0; i < weights.length; i++) {
            if (i % 2 == 0) {
                teamOneWeight += weights[i];
            } else {
                teamTwoWeight += weights[i];
            }
        }
        return new int[]{teamOneWeight, teamTwoWeight};
    }
}
