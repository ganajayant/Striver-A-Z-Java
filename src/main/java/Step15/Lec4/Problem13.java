package Step15.Lec4;

import java.util.Arrays;

public class Problem13 {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int[][] matrix = new int[n][n];
        for (int[] is : matrix) {
            Arrays.fill(is, Integer.MAX_VALUE);
        }
        for (int[] is : edges) {
            int a = is[0];
            int b = is[1];
            int weight = is[2];
            matrix[a][b] = weight;
            matrix[b][a] = weight;
        }
        for (int i = 0; i < n; i++) {
            matrix[i][i] = 0;
        }
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (matrix[i][k] != Integer.MAX_VALUE && matrix[k][j] != Integer.MAX_VALUE) {
                        matrix[i][j] = Math.min(matrix[i][j], matrix[i][k] + matrix[k][j]);
                    }
                }
            }
        }
        int res = 0, smallest = n;
        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = 0; j < n; ++j) {
                if (matrix[i][j] <= distanceThreshold) {
                    ++count;
                }
            }
            if (count <= smallest) {
                res = i;
                smallest = count;
            }
        }
        return res;
    }
}
