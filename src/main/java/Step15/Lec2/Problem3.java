package Step15.Lec2;

import java.util.LinkedList;

class Node {
    int i;
    int j;
    int time;

    public Node(int i, int j, int time) {
        this.i = i;
        this.j = j;
        this.time = time;
    }
}

public class Problem3 {
    public int orangesRotting(int[][] grid) {
        LinkedList<Node> queue = new LinkedList<>();
        int freshOranges = 0;
        int time = 0;
        int rows = grid.length;
        int cols = grid[0].length;
        int visited[][] = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1) {
                    freshOranges++;
                } else if (grid[i][j] == 2) {
                    queue.add(new Node(i, j, 0));
                    visited[i][j] = 2;
                }
            }
        }
        int count = 0;
        int x[] = { -1, 0, 1, 0 };
        int y[] = { 0, 1, 0, -1 };

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            time = node.time;
            for (int i = 0; i < 4; i++) {
                int newI = node.i + x[i];
                int newJ = node.j + y[i];
                if (newI >= 0 && newI < rows && newJ >= 0 && newJ < cols && grid[newI][newJ] == 1
                        && visited[newI][newJ] == 0) {
                    visited[newI][newJ] = 2;
                    count++;
                    queue.add(new Node(newI, newJ, node.time + 1));
                }
            }
        }

        if (count == freshOranges) {
            return time;
        }
        return -1;

    }
}
