package Step16.Lec8;

import java.util.Arrays;

public class Problem6 {
    private boolean isPalindrome(String s, int i, int j) {
        while (i <= j) {
            if (s.charAt(i++) != s.charAt(j--)) {
                return false;
            }
        }
        return true;
    }

    private int recursion(String s, int i, int j, int[][] dp) {
        if (i >= j) {
            return 0;
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        if (isPalindrome(s, i, j)) {
            return 0;
        }
        int min = Integer.MAX_VALUE;
        for (int k = i; k <= j - 1; k++) {
            int temp = recursion(s, i, k, dp) + recursion(s, k + 1, j, dp) + 1;
            min = Math.min(min, temp);
        }
        return dp[i][j] = min;
    }

    public int minCut(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];
        for (int[] is : dp) {
            Arrays.fill(is, -1);
        }
        return recursion(s, 0, n - 1, dp);
    }
}
