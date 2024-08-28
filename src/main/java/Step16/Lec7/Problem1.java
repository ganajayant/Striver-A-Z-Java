package Step16.Lec7;

import java.util.Arrays;

public class Problem1 {
    private int recursion(int[] nums, int index, int n, int prev_index, int[][] dp) {
        if (index == n) {
            return 0;
        }
        if (dp[index][prev_index + 1] != -1) {
            return dp[index][prev_index + 1];
        }
        int a = 0;
        if (prev_index == -1 || nums[prev_index] < nums[index]) {
            a = 1 + recursion(nums, index + 1, n, index, dp);
        }
        int b = recursion(nums, index + 1, n, prev_index, dp);
        return dp[index][prev_index + 1] = Math.max(a, b);
    }

    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n][n + 1];
        for (int[] is : dp) {
            Arrays.fill(is, -1);
        }
        return recursion(nums, 0, n, -1, dp);
    }
}
