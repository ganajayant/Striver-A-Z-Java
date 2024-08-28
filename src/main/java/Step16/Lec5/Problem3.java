package Step16.Lec5;

public class Problem3 {
    public int longestCommonSubstr(String s1, String s2) {
        int m = s1.length(), n = s2.length();
        int[][] dp = new int[m + 1][n + 1];
        int max = Integer.MIN_VALUE;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j] = s1.charAt(i - 1) == s2.charAt(j - 1) ? 1 + dp[i - 1][j - 1] : 0;
                max = Math.max(dp[i][j], max);
            }
        }
        return max;
    }
}
