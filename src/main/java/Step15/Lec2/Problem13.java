package Step15.Lec2;

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

class Solution {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        DisjointSet ds = new DisjointSet(n);
        for (int i = 0; i < n; i++) {
            for (int j : graph[i]) {
                if (ds.find(i) == ds.find(j)) {
                    return false;
                }
                ds.union(graph[i][0], j);
            }
        }
        return true;
    }
}
