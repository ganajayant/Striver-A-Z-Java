package Step16.Lec7;

import java.util.ArrayList;
import java.util.Arrays;

public class Problem2 {

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

    public ArrayList<Integer> longestIncreasingSubsequence(int n, int arr[]) {
        int[][] dp = new int[n][n + 1];
        for (int[] is : dp) {
            Arrays.fill(is, -1);
        }
        recursion(arr, 0, n, -1, dp);
        ArrayList<Integer> result = new ArrayList<>();
        int index = 0, prev_index = -1;
        while (index < n) {
            if (prev_index == -1 || arr[prev_index] < arr[index]) {
                if (dp[index][prev_index + 1] == 1 + (index + 1 < n ? dp[index + 1][index + 1] : 0)) {
                    result.add(arr[index]);
                    prev_index = index;
                }
            }
            index++;
        }
        return result;
    }

}
