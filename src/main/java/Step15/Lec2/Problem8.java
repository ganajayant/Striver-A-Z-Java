package Step15.Lec2;

public class Problem8 {

    private void dfs(char[][] board, boolean[][] visited, int i, int j) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || visited[i][j] || board[i][j] == 'X') {
            return;
        }
        visited[i][j] = true;
        dfs(board, visited, i - 1, j);
        dfs(board, visited, i + 1, j);
        dfs(board, visited, i, j - 1);
        dfs(board, visited, i, j + 1);
    }

    public void solve(char[][] board) {
        int m = board.length, n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            dfs(board, visited, i, 0);
            dfs(board, visited, i, n - 1);
        }
        for (int j = 0; j < n; j++) {
            dfs(board, visited, 0, j);
            dfs(board, visited, m - 1, j);
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = visited[i][j] ? 'O' : 'X';
            }
        }
    }
}