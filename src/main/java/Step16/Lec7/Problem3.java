package Step16.Lec7;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Problem3 {
    private int recursion(int[] nums, int index, int n, int prev_index, int[][] dp) {
        if (index >= n) {
            return 0;
        }
        if (dp[index][prev_index + 1] != -1) {
            return dp[index][prev_index + 1];
        }

        int take = 0;
        if (prev_index == -1 || ((nums[prev_index] % nums[index] == 0) || (nums[index] % nums[prev_index] == 0))) {
            take = 1 + recursion(nums, index + 1, n, index, dp);
        }
        int not_take = recursion(nums, index + 1, n, prev_index, dp);
        return dp[index][prev_index + 1] = Math.max(take, not_take);
    }

    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int[][] dp = new int[n][n + 1];
        for (int[] is : dp) {
            Arrays.fill(is, -1);
        }
        recursion(nums, 0, n, -1, dp);
        int index = 0, prev_index = -1;
        List<Integer> result = new LinkedList<>();
        int maxLength = dp[0][0];
        while (index < n) {
            if (prev_index == -1 || (nums[index] % nums[prev_index] == 0 || nums[prev_index] % nums[index] == 0)) {
                if (dp[index][prev_index + 1] == maxLength) {
                    result.add(nums[index]);
                    prev_index = index;
                    maxLength--;
                }
            }
            index++;
        }
        return result;
    }
}
