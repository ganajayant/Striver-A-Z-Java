package Step15.Lec6;

import java.util.ArrayList;
import java.util.Stack;

public class Problem3 {
    private void dfs(int node, boolean[] visted, ArrayList<ArrayList<Integer>> adj, Stack<Integer> s) {
        visted[node] = true;
        for (Integer integer : adj.get(node)) {
            if (!visted[integer]) {
                dfs(integer, visted, adj, s);
            }
        }
        if (s != null) {
            s.add(node);
        }
    }

    public int kosaraju(int V, ArrayList<ArrayList<Integer>> adj) {
        Stack<Integer> stacky = new Stack<>();
        boolean[] visited = new boolean[V];
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                dfs(i, visited, adj, stacky);
            }
        }
        ArrayList<ArrayList<Integer>> newadj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            newadj.add(new ArrayList<>());
        }
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < adj.get(i).size(); j++) {
                newadj.get(adj.get(i).get(j)).add(i);
            }
        }
        visited = new boolean[V];
        int count = 0;
        while (!stacky.isEmpty()) {
            int node = stacky.pop();
            if (!visited[node]) {
                dfs(node, visited, newadj, null);
                count++;
            }
        }
        return count;
    }
}
