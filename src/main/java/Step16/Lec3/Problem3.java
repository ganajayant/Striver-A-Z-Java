package Step16.Lec3;

import java.util.Arrays;

public class Problem3 {
    private int f(int[][] obstacleGrid, int i, int j, int[][] memo, int m, int n) {
        if (i < 0 || j < 0 || i >= m || j >= n) {
            return 0;
        }
        if (memo[i][j] != -1) {
            return memo[i][j];
        }
        if (obstacleGrid[i][j] == 1) {
            return 0;
        }
        if (i == m - 1 && j == n - 1) {
            return 1;
        }
        int ans = f(obstacleGrid, i + 1, j, memo, m, n);
        ans += f(obstacleGrid, i, j + 1, memo, m, n);
        return ans;
    }

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length, n = obstacleGrid[0].length;
        int[][] memo = new int[m][n];
        for (int[] is : memo) {
            Arrays.fill(is, -1);
        }
        return f(obstacleGrid, 0, 0, memo, m, n);
    }
}
