package Step15.Lec4;

import java.util.LinkedList;
import java.util.Queue;

public class Problem5 {
    class Node {
        int i, j, distance;

        public Node(int i, int j, int distance) {
            this.i = i;
            this.j = j;
            this.distance = distance;
        }
    }

    public int shortestPathBinaryMatrix(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        if (grid[0][0] == 1 || grid[m - 1][n - 1] == 1) {
            return -1;
        }

        boolean[][] visited = new boolean[m][n];
        Queue<Node> q = new LinkedList<>();

        q.add(new Node(0, 0, 1));
        visited[0][0] = true;
        int[][] directions = {
                { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 },
                { 1, 1 }, { -1, -1 }, { 1, -1 }, { -1, 1 }
        };

        while (!q.isEmpty()) {
            Node current = q.poll();
            int i = current.i, j = current.j, distance = current.distance;

            if (i == m - 1 && j == n - 1) {
                return distance;
            }
            for (int[] direction : directions) {
                int newI = i + direction[0], newJ = j + direction[1];
                if (newI >= 0 && newI < m && newJ >= 0 && newJ < n && grid[newI][newJ] == 0 && !visited[newI][newJ]) {
                    q.add(new Node(newI, newJ, distance + 1));
                    visited[newI][newJ] = true;
                }
            }
        }
        return -1;

    }
}
