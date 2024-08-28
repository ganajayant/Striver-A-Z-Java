package Step15.Lec2;

import java.util.ArrayList;
import java.util.Arrays;

public class Problem6 {
    private boolean dfs(int src, int parent, boolean[] visited, ArrayList<ArrayList<Integer>> adj) {
        visited[src] = true;
        for (Integer adjnode : adj.get(src)) {
            if (!visited[adjnode]) {
                visited[adjnode] = true;
                if (dfs(adjnode, src, visited, adj)) {
                    return true;
                }
            } else if (parent != adjnode) {
                return true;
            }
        }
        return false;
    }

    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean[] visited = new boolean[V];
        Arrays.fill(visited, false);
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                if (dfs(i, -1, visited, adj)) {
                    return true;
                }
            }
        }
        return false;
    }
}
