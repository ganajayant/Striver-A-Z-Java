package Step16.Lec3;

public class Problem1 {
    public int maximumPoints(int points[][], int N) {
        int[][] dp = new int[N][3];
        for (int j = 0; j < 3; j++) {
            dp[0][j] = points[0][j];
        }
        for (int i = 1; i < N; i++) {
            for (int j = 0; j < 3; j++) {
                dp[i][j] = points[i][j] + Math.max(dp[i - 1][(j + 1) % 3], dp[i - 1][(j + 2) % 3]);
            }
        }
        return Math.max(dp[N - 1][0], Math.max(dp[N - 1][1], dp[N - 1][2]));
    }
}
