package Step16.Lec4;

import java.util.Arrays;

public class Problem9 {
    private int recursion(int[] coins, int amount, int index, int n, int current_sum, int[][] dp) {
        if (index == n) {
            return current_sum == amount ? 1 : 0;
        }
        if (dp[index][current_sum] != -1) {
            return dp[index][current_sum];
        }
        int count = 0;
        if (coins[index] <= (amount - current_sum)) {
            count += recursion(coins, amount, index, n, current_sum + coins[index], dp);
        }
        count += recursion(coins, amount, index + 1, n, current_sum, dp);
        return dp[index][current_sum] = count;
    }

    public int change(int amount, int[] coins) {
        int n = coins.length;
        int[][] dp = new int[n][amount];
        for (int[] is : dp) {
            Arrays.fill(is, -1);
        }
        return recursion(coins, amount, 0, coins.length, 0, dp);
    }
}
