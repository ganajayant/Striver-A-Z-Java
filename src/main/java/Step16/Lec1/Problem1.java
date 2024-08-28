package Step16.Lec1;

import java.util.Arrays;

public class Problem1 {
    private static long recursion(int n, long[] dp) {
        if (n <= 1) {
            return n;
        }
        if (dp[n] != -1)
            return dp[n];
        dp[n] = (recursion(n - 1, dp) + recursion(n - 2, dp)) % 1000000007;
        return dp[n] % 1000000007;
    }

    static long topDown(int n) {
        long[] dp = new long[n + 1];
        Arrays.fill(dp, -1);
        return recursion(n, dp);
    }

    static long bottomUp(int n) {
        if (n <= 1) {
            return n;
        }
        long a = 0, b = 1;
        int m = 1000000007;
        for (int i = 0; i < n; i++) {
            long sum = (a + b) % m;
            a = b;
            b = sum;
        }
        return b;
    }

}
