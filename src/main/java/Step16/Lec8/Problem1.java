package Step16.Lec8;

import java.util.Arrays;

public class Problem1 {
    private static int solve(int i, int j, int[] arr, int[][] dp) {
        if (j == i) {
            return 0;
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        int min = Integer.MAX_VALUE;
        for (int k = i; k <= j - 1; k++) {
            int temp = solve(i, k, arr, dp) + solve(k + 1, j, arr, dp) + arr[i - 1] * arr[k] * arr[j];
            min = Math.min(min, temp);
        }
        return dp[i][j] = min;
    }

    static int matrixMultiplication(int N, int arr[]) {
        int[][] dp = new int[N][N];
        for (int[] is : dp) {
            Arrays.fill(is, -1);
        }
        return solve(1, N - 1, arr, dp);
    }
}
