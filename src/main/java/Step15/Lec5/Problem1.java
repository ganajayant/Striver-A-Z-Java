package Step15.Lec5;

import java.util.List;
import java.util.PriorityQueue;

class DisjointSet {
    int[] parent;
    int[] rank;

    public DisjointSet(int V) {
        parent = new int[V + 1];
        rank = new int[V + 1];
        for (int i = 0; i <= V; i++) {
            parent[i] = i;
        }
    }

    public int find(int i) {
        if (i != parent[i]) {
            parent[i] = find(parent[i]);
        }
        return parent[i];
    }

    public void union(int i, int j) {
        int rootI = find(i);
        int rootJ = find(j);
        if (rootI != rootJ) {
            if (rank[rootI] > rank[rootJ]) {
                parent[rootJ] = rootI;
            } else if (rank[rootI] < rank[rootJ]) {
                parent[rootI] = rootJ;
            } else {
                parent[rootJ] = rootI;
                rank[rootI]++;
            }
        }
    }
}

class Edge implements Comparable<Edge> {
    int x;
    int y;
    int weight;

    public Edge(int x, int y, int weight) {
        this.x = x;
        this.y = y;
        this.weight = weight;
    }

    @Override
    public int compareTo(Edge o) {
        return this.weight - o.weight;
    }
}

public class Problem1 {
    static int spanningTree(int V, int E, List<List<int[]>> adj) {
        DisjointSet ds = new DisjointSet(V);
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        int cost = 0;
        for (int i = 0; i < V; i++) {
            for (int[] row : adj.get(i)) {
                pq.add(new Edge(i, row[0], row[1]));
            }
        }
        while (!pq.isEmpty()) {
            Edge e = pq.poll();
            if (ds.find(e.x) != ds.find(e.y)) {
                ds.union(e.x, e.y);
                cost += e.weight;
            }
        }
        return cost;
    }
}