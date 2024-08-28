package Step16.Lec4;

import java.util.Arrays;

public class Problem11 {
    private int recursion(int price[], int index, int remainging_length, int[][] dp) {
        if (remainging_length == 0) {
            return 0;
        }
        if (index == price.length) {
            return 0;
        }
        if (dp[index][remainging_length] != Integer.MIN_VALUE) {
            return dp[index][remainging_length];
        }
        int max = Integer.MIN_VALUE;
        if (index + 1 <= remainging_length) {
            max = Math.max(max, price[index] + recursion(price, index, remainging_length - (index + 1), dp));
        }
        return dp[index][remainging_length] = Math.max(max, recursion(price, index + 1, remainging_length, dp));
    }

    public int cutRod(int price[], int n) {
        int[][] dp = new int[n + 1][n + 1];
        for (int[] is : dp) {
            Arrays.fill(is, Integer.MIN_VALUE);
        }
        return recursion(price, 0, n, dp);
    }
}
