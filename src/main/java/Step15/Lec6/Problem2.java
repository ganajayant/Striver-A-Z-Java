package Step15.Lec6;

import java.util.ArrayList;

public class Problem2 {
    int timer = 1;

    private void dfs(int node, int parent, ArrayList<ArrayList<Integer>> graph, boolean[] visited, int[] dfs_number,
            int[] low, boolean[] marked) {
        visited[node] = true;
        int childCount = 0;
        dfs_number[node] = low[node] = timer++;
        for (Integer next : graph.get(node)) {
            if (next == parent) {
                continue;
            }
            if (!visited[next]) {
                childCount++;
                dfs(next, node, graph, visited, dfs_number, low, marked);
                low[node] = Math.min(low[node], low[next]);
                if (low[next] >= dfs_number[node] && parent != -1) {
                    marked[node] = true;
                }

            } else {
                low[node] = Math.min(low[node], dfs_number[next]);
            }
        }
        if (parent == -1 && childCount > 1) {
            marked[node] = true;
        }
    }

    public ArrayList<Integer> articulationPoints(int V, ArrayList<ArrayList<Integer>> adj) {
        int[] dfs_number = new int[V];
        int[] low = new int[V];
        boolean[] visited = new boolean[V];
        boolean[] marked = new boolean[V];
        dfs(0, -1, adj, visited, dfs_number, low, marked);
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            if (marked[i]) {
                result.add(i);
            }
        }
        if (result.size() == 0) {
            result.add(-1);
        }
        return result;
    }
}
