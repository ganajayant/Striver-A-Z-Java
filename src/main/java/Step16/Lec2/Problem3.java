package Step16.Lec2;

import java.util.Arrays;

public class Problem3 {

    public int minimizeCost(int arr[], int N, int K) {
        int[] dp = new int[N];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for (int i = 1; i < N; i++) {
            for (int j = 1; j <= K; j++) {
                if (i - j >= 0) {
                    dp[i] = Math.min(dp[i], Math.abs(arr[i] - arr[i - j]) + dp[i - j]);
                }
            }
        }
        return dp[N - 1];
    }
}
