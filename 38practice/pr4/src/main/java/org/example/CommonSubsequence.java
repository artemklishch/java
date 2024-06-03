package org.example;

public class CommonSubsequence {
    public static String getLongestCommonSubsequence(String string1, String string2) {
        int m = string1.length();
        int n = string2.length();

        // Динамічна таблиця для збереження довжин підпослідовностей
        int[][] dp = new int[m + 1][n + 1];

        // Заповнення таблиці dp
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (string1.charAt(i - 1) == string2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        // Відновлення найдовшої спільної підпослідовності
        StringBuilder lcs = new StringBuilder();
        int i = m, j = n;
        while (i > 0 && j > 0) {
            if (string1.charAt(i - 1) == string2.charAt(j - 1)) {
                lcs.append(string1.charAt(i - 1));
                i--;
                j--;
            } else if (dp[i - 1][j] > dp[i][j - 1]) {
                i--;
            } else {
                j--;
            }
        }

        // Оскільки ми заповнювали lcs з кінця до початку, потрібно розвернути його
        return lcs.reverse().toString();
    }
}
