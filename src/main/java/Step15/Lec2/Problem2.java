package Step15.Lec2;

import java.util.ArrayList;

class DisJoint {
    int n;
    int[] rank;
    int[] parent;

    public DisJoint(int n) {
        this.n = n;
        rank = new int[this.n + 1];
        parent = new int[this.n + 1];
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }
    }

    public int FindUParent(int i) {
        if (parent[i] == i) {
            return i;
        }
        return parent[i] = FindUParent(parent[i]);
    }

    public void Union(int i, int j) {
        int UIParent = FindUParent(i);
        int UJParent = FindUParent(j);
        if (UIParent == UJParent) {
            return;
        }
        if (rank[UIParent] < rank[UJParent]) {
            this.parent[UIParent] = UJParent;
        } else if (rank[UIParent] > rank[UJParent]) {
            this.parent[UJParent] = UIParent;
        } else {
            this.parent[UJParent] = UIParent;
            rank[UIParent]++;
        }
    }
}

public class Problem2 {
    static int numProvinces(ArrayList<ArrayList<Integer>> adj, int V) {
        DisJoint d = new DisJoint(V);
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                if (adj.get(i).get(j) == 1) {
                    d.Union(i, j);
                }
            }
        }
        int count = 0;
        for (int i = 0; i < d.parent.length; i++) {
            if (d.parent[i] == i) {
                count++;
            }
        }
        return count - 1;
    }
}
