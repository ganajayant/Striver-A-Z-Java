package Step15.Lec4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Problem4 {
    static class Node implements Comparable<Node> {
        int vertex, weight;

        public Node(int vertex, int weight) {
            this.vertex = vertex;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node other) {
            return this.weight - other.weight;
        }
    }

    static int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S) {
        int[] min = new int[V];
        Arrays.fill(min, Integer.MAX_VALUE);
        min[S] = 0;
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(S, 0));

        while (!pq.isEmpty()) {
            Node current = pq.poll();
            int currentNode = current.vertex;
            int currentWeight = current.weight;

            if (currentWeight > min[currentNode]) {
                continue;
            }
            ArrayList<ArrayList<Integer>> neighbors = adj.get(currentNode);
            for (ArrayList<Integer> neighbor : neighbors) {
                int nextNode = neighbor.get(0);
                int weightToNext = neighbor.get(1);
                int newWeight = currentWeight + weightToNext;

                if (newWeight < min[nextNode]) {
                    min[nextNode] = newWeight;
                    pq.add(new Node(nextNode, newWeight));
                }
            }
        }

        for (int i = 0; i < V; i++) {
            if (min[i] == Integer.MAX_VALUE) {
                min[i] = -1;
            }
        }

        return min;
    }
}
