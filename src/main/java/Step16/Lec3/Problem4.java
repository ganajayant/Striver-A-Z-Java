package Step16.Lec3;

import java.util.Arrays;

public class Problem4 {

    private int f(int[][] grid, int i, int j, int m, int n, int[][] dp) {
        if (i < 0 || j < 0 || i >= m || j >= n) {
            return Integer.MAX_VALUE;
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        if (i == m - 1 && j == n - 1) {
            return grid[i][j];
        }
        return dp[i][j] = grid[i][j]
                + Math.min(f(grid, i + 1, j, m, n, dp), f(grid, i, j + 1, m, n, dp));
    }

    public int minPathSum(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] dp = new int[m][n];
        for (int[] is : dp) {
            Arrays.fill(is, -1);
        }
        return f(grid, 0, 0, m, n, dp);
    }
}
