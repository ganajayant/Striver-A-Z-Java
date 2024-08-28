package Step15.Lec2;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class FloodNode {
    int i;
    int j;

    public FloodNode(int i, int j) {
        this.i = i;
        this.j = j;
    }
}

public class Problem4 {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int m = image.length, n = image[0].length;
        int orignalcolor = image[sr][sc];
        Queue<FloodNode> q = new LinkedList<>();
        Boolean[][] visited = new Boolean[m][n];
        for (Boolean[] booleans : visited) {
            Arrays.fill(booleans, false);
        }
        q.add(new FloodNode(sr, sc));
        visited[sr][sc] = true;
        image[sr][sc] = color;
        int[][] dir = { { -1, 0 }, { 1, 0 }, { 0, 1 }, { 0, -1 } };
        while (!q.isEmpty()) {
            FloodNode temp = q.poll();
            for (int i = 0; i < dir.length; i++) {
                int newi = temp.i + dir[i][0];
                int newj = temp.j + dir[i][1];
                if (newi >= 0 && newi < m && newj >= 0 && newj < n && !visited[newi][newj]
                        && image[newi][newj] == orignalcolor) {
                    image[newi][newj] = color;
                    visited[newi][newj] = true;
                    q.add(new FloodNode(newi, newj));
                }
            }
        }
        return image;
    }
}
