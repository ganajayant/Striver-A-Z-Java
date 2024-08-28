package Step16.Lec2;

import java.util.Arrays;

public class Problem1 {
    private int recursion(int n, int[] dp) {
        if (n == 0) {
            return 1;
        }
        if (dp[n] != -1) {
            return dp[n];
        }
        int count = 0;
        if (n > 1) {
            count += recursion(n - 2, dp);
        }
        return dp[n] = count + recursion(n - 1, dp);
    }

    public int climbStairs(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        return recursion(n, dp);
    }
}
