package Step16.Lec4;

import java.util.Arrays;

public class Problem10 {
    private static int recursion(int val[], int wt[], int index, int n, int weight, int[][] dp) {
        if (index >= n) {
            return 0;
        }
        if (weight == 0) {
            return 0;
        }
        if (dp[index][weight] != Integer.MIN_VALUE) {
            return dp[index][weight];
        }
        int max = Integer.MIN_VALUE;
        if (wt[index] <= weight) {
            max = Math.max(max, val[index] + recursion(val, wt, index, n, weight - wt[index], dp));
        }
        return dp[index][weight] = Math.max(max, recursion(val, wt, index + 1, n, weight, dp));
    }

    static int knapSack(int N, int W, int val[], int wt[]) {
        int[][] dp = new int[N + 1][W + 1];
        for (int[] is : dp) {
            Arrays.fill(is, Integer.MIN_VALUE);
        }
        return recursion(val, wt, 0, N, W, dp);
    }
}
