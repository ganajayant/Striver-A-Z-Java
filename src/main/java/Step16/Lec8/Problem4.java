package Step16.Lec8;

import java.util.Arrays;

public class Problem4 {
    private int solve(int[] nums, int i, int j, int[][] dp) {
        if (i > j) {
            return 0;
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        int max = Integer.MIN_VALUE;
        for (int k = i; k <= j; k++) {
            int temp = 1;
            if (i < 1) {
                temp *= 1;
            } else {
                temp *= nums[i - 1];
            }
            if (j >= nums.length - 1) {
                temp *= 1;
            } else {
                temp *= nums[j + 1];
            }
            temp *= nums[k];
            temp += solve(nums, i, k - 1, dp) + solve(nums, k + 1, j, dp);
            max = Math.max(temp, max);
        }
        return dp[i][j] = max;
    }

    public int maxCoins(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n][n];
        for (int[] is : dp) {
            Arrays.fill(is, -1);
        }
        return solve(nums, 0, nums.length - 1, dp);
    }
}
