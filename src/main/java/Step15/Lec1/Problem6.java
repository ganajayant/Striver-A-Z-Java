package Step15.Lec1;

import java.util.ArrayList;

public class Problem6 {
    private ArrayList<Integer> dfs(int node, ArrayList<ArrayList<Integer>> adj, ArrayList<Integer> result,
            boolean[] visited) {
        if (visited[node]) {
            return result;
        }
        visited[node] = true;
        result.add(node);
        for (int i : adj.get(node)) {
            if (!visited[i]) {
                dfs(i, adj, result, visited);
            }
        }
        return result;
    }

    public ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        return dfs(0, adj, result, new boolean[V]);
    }
}
