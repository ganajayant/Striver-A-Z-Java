package Step16.Lec4;

import java.util.Arrays;

public class Problem7 {
    private int recursion(int[] coins, int amount, int current_amount, int index, int n, int[][] dp) {
        if (amount == current_amount) {
            return 0;
        }
        if (index >= n || current_amount > amount) {
            return Integer.MAX_VALUE;
        }
        if (dp[index][current_amount] != -1) {
            return dp[index][current_amount];
        }
        int min = Integer.MAX_VALUE;
        if (coins[index] <= (amount - current_amount)) {
            int ans = (recursion(coins, amount, current_amount + coins[index], index, n, dp));
            if (ans != Integer.MAX_VALUE) {
                min = Math.min(min, 1 + ans);
            }
        }
        return dp[index][current_amount] = Math.min(min, recursion(coins, amount, current_amount, index + 1, n, dp));
    }

    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int[][] dp = new int[n][amount];
        for (int[] is : dp) {
            Arrays.fill(is, -1);
        }
        int ans = recursion(coins, amount, 0, 0, n, dp);
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}
