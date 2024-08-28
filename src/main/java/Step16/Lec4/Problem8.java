package Step16.Lec4;

import java.util.Arrays;

public class Problem8 {
    private int recursion(int[] nums, int target, int index, int current_sum, int n, int dp[][], int total) {
        if (index == n) {
            return current_sum == target ? 1 : 0;
        }
        if (dp[index][current_sum + total] != Integer.MIN_VALUE) {
            return dp[index][total + current_sum];
        }
        return dp[index][current_sum
                + total] = (recursion(nums, target, index + 1, current_sum + nums[index], n, dp, total)
                        + recursion(nums, target, index + 1, current_sum - nums[index], n, dp, total));
    }

    public int findTargetSumWays(int[] nums, int target) {
        int total_sum = 0;
        for (int i : nums) {
            total_sum += i;
        }
        int n = nums.length;
        int[][] dp = new int[n + 1][2 * total_sum + 1];
        for (int[] is : dp) {
            Arrays.fill(is, Integer.MIN_VALUE);
        }
        return recursion(nums, target, 0, 0, n, dp, total_sum);
    }
}
