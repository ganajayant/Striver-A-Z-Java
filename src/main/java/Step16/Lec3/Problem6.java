package Step16.Lec3;

import java.util.Arrays;

public class Problem6 {
    private int f(int[][] matrix, int row, int col, int[][] dp) {
        if (row == matrix.length) {
            return 0;
        }
        if (dp[row][col] != Integer.MAX_VALUE) {
            return dp[row][col];
        }
        int min = Integer.MAX_VALUE;
        if (col > 0 && col < matrix[0].length) {
            min = Math.min(min, matrix[row][col - 1] + f(matrix, row + 1, col - 1, dp));
        }
        if (col >= 0 && col < matrix[0].length) {
            min = Math.min(min, matrix[row][col] + f(matrix, row + 1, col, dp));
        }
        if (col >= 0 && col + 1 < matrix[0].length) {
            min = Math.min(min, matrix[row][col + 1] + f(matrix, row + 1, col + 1, dp));
        }
        return dp[row][col] = min;
    }

    public int minFallingPathSum(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int[][] dp = new int[m][n];
        for (int[] is : dp) {
            Arrays.fill(is, Integer.MAX_VALUE);
        }
        int min = Integer.MAX_VALUE;
        for (int j = 0; j < matrix[0].length; j++) {
            min = Math.min(min, matrix[0][j] + f(matrix, 1, j, dp));
        }
        return min;
    }
}
