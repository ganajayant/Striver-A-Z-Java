package Step16.Lec5;

import java.util.Arrays;

public class Problem1 {
    private int recursion(String text1, String text2, int i, int j, int m, int n, int[][] dp) {
        if (i >= m) {
            return 0;
        }
        if (j >= n) {
            return 0;
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        if (text1.charAt(i) == text2.charAt(j)) {
            return 1 + recursion(text1, text2, i + 1, j + 1, m, n, dp);
        }
        return Math.max(recursion(text1, text2, i + 1, j, m, n, dp), recursion(text1, text2, i, j + 1, m, n, dp));
    }

    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length(), n = text2.length();
        int[][] dp = new int[m][n];
        for (int[] is : dp) {
            Arrays.fill(is, -1);
        }
        return recursion(text1, text2, 0, 0, m, n, dp);
    }
}
