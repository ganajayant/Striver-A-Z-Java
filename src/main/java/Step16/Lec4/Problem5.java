package Step16.Lec4;

public class Problem5 {
    public static int countPartitions(int n, int d, int[] arr) {
        int total_sum = 0;
        for (int i : arr) {
            total_sum += i;
        }
        if ((total_sum + d) % 2 != 0) {
            return 0;
        }
        int mod = 1000000007;
        int targetSum = (total_sum + d) / 2;
        int[][] dp = new int[n + 1][targetSum + 1];
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= targetSum; j++) {
                if (arr[i - 1] <= j) {
                    dp[i][j] = (dp[i - 1][j - arr[i - 1]] + dp[i - 1][j]) % mod;
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[n][targetSum];
    }
}
