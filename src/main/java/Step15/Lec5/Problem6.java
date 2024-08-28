package Step15.Lec5;

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

public class Problem6 {
    public int makeConnected(int n, int[][] connections) {
        DisJoint ds = new DisJoint(n);
        int edges = connections.length;
        if (edges < n - 1) {
            return -1;
        }
        for (int[] is : connections) {
            ds.Union(is[0], is[1]);
        }
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (ds.FindUParent(i) == i) {
                count++;
            }
        }
        return count - 1;
    }
}