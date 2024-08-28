package Step15.Lec2;

public class Problem7 {
    private void distance(int[][] mat, int length, int m, int n, boolean[][] visited, int i, int j) {
        if (i < 0 || j < 0 || i >= m || j >= n || (length != 0 && mat[i][j] == 0)) {
            return;
        }
        if (visited[i][j] && mat[i][j] <= length) {
            return;
        }
        mat[i][j] = length;
        visited[i][j] = true;
        distance(mat, length + 1, m, n, visited, i + 1, j);
        distance(mat, length + 1, m, n, visited, i - 1, j);
        distance(mat, length + 1, m, n, visited, i, j + 1);
        distance(mat, length + 1, m, n, visited, i, j - 1);
    }

    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) {
                    distance(mat, 0, m, n, visited, i, j);
                }
            }
        }
        return mat;
    }
}
