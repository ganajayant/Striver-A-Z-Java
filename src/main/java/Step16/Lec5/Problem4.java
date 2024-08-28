package Step16.Lec5;

import java.util.Arrays;

public class Problem4 {
    private int recursion(String s, int i, int j, int[][] dp) {
        if (i > j) {
            return 0;
        }
        if (i == j) {
            return 1;
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        int max = Integer.MIN_VALUE;
        if (s.charAt(i) == s.charAt(j)) {
            max = Math.max(max, 2 + recursion(s, i + 1, j - 1, dp));
        }
        return dp[i][j] = Math.max(max, Math.max(recursion(s, i, j - 1, dp), recursion(s, i + 1, j, dp)));
    }

    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];
        for (int[] is : dp) {
            Arrays.fill(is, -1);
        }
        return recursion(s, 0, s.length() - 1, dp);
    }
}
