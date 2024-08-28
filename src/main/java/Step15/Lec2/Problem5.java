package Step15.Lec2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class GraphNode {
    int parent;
    int node;

    public GraphNode(int parent, int node) {
        this.parent = parent;
        this.node = node;
    }
}

public class Problem5 {
    private boolean detected(int src, ArrayList<ArrayList<Integer>> adj, boolean[] visited) {
        visited[src] = true;
        Queue<GraphNode> q = new LinkedList<>();
        q.add(new GraphNode(-1, src));
        while (!q.isEmpty()) {
            GraphNode temp = q.poll();
            for (Integer adjnode : adj.get(temp.node)) {
                if (!visited[adjnode]) {
                    visited[adjnode] = true;
                    q.add(new GraphNode(temp.node, adjnode));
                } else {
                    if (temp.parent != adjnode) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean[] visited = new boolean[V];
        Arrays.fill(visited, false);
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                boolean flag = detected(i, adj, visited);
                if (flag) {
                    return true;
                }
            }
        }
        return false;
    }
}
