package Step15.Lec2;

public class Problem9 {
    private void dfs(int[][] board, boolean[][] visited, int i, int j) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || visited[i][j] || board[i][j] == 0) {
            return;
        }
        visited[i][j] = true;
        dfs(board, visited, i - 1, j);
        dfs(board, visited, i + 1, j);
        dfs(board, visited, i, j - 1);
        dfs(board, visited, i, j + 1);
    }

    public int numEnclaves(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            if (grid[i][0] == 1) {
                dfs(grid, visited, i, 0);
            }
            if (grid[i][n - 1] == 1) {
                dfs(grid, visited, i, n - 1);
            }
        }
        for (int j = 0; j < n; j++) {
            if (grid[0][j] == 1) {
                dfs(grid, visited, 0, j);
            }
            if (grid[m - 1][j] == 1) {
                dfs(grid, visited, m - 1, j);
            }
        }
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    count++;
                }
            }
        }
        return count;
    }
}
