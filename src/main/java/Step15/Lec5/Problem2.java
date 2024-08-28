package Step15.Lec5;

import java.util.List;
import java.util.PriorityQueue;

class Pair implements Comparable<Pair> {
    int node;
    int weight;

    public Pair(int node, int weight) {
        this.node = node;
        this.weight = weight;
    }

    @Override
    public int compareTo(Pair o) {
        return this.weight - o.weight;
    }
}

public class Problem2 {
    static int spanningTree(int V, int E, List<List<int[]>> adj) {
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        boolean[] visited = new boolean[V];
        pq.add(new Pair(0, 0));
        int sum = 0;
        while (!pq.isEmpty()) {
            Pair x = pq.poll();
            if (visited[x.node]) {
                continue;
            }
            visited[x.node] = true;
            sum += x.weight;
            for (int[] l : adj.get(x.node)) {
                if (!visited[l[0]]) {
                    pq.add(new Pair(l[0], l[1]));
                }
            }
        }
        return sum;
    }
}