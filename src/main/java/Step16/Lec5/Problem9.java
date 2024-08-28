package Step16.Lec5;

import java.util.Arrays;

public class Problem9 {
    private int f(String word1, String word2, int i, int j, int[][] dp) {
        if (i < 0) {
            return j + 1;
        }
        if (j < 0) {
            return i + 1;
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        if (word1.charAt(i) == word2.charAt(j)) {
            return dp[i][j] = f(word1, word2, i - 1, j - 1, dp);
        }
        return dp[i][j] = 1 + Math.min(f(word1, word2, i - 1, j, dp),
                Math.min(f(word1, word2, i, j - 1, dp), f(word1, word2, i - 1, j - 1, dp)));
    }

    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int[][] dp = new int[m][n];
        for (int[] is : dp) {
            Arrays.fill(is, -1);
        }
        return f(word1, word2, m - 1, n - 1, dp);
    }
}