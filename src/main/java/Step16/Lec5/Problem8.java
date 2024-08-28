package Step16.Lec5;

import java.util.Arrays;

public class Problem8 {
    private int recursion(String s, String t, int i, int j, int[][] dp) {
        if (j == 0) {
            return 1;
        }
        if (i == 0) {
            return 0;
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        int ans = 0;
        if (s.charAt(i - 1) == t.charAt(j - 1)) {
            ans += recursion(s, t, i - 1, j - 1, dp);
        }
        ans += recursion(s, t, i - 1, j, dp);
        return dp[i][j] = ans;
    }

    public int numDistinct(String s, String t) {
        int m = s.length();
        int n = t.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return recursion(s, t, m, n, dp);
    }
}
