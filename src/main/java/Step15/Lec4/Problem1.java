package Step15.Lec4;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

class Node implements Comparable<Node> {
    int a, b, weight;

    public Node(int a, int b, int weight) {
        this.a = a;
        this.b = b;
        this.weight = weight;
    }

    @Override
    public int compareTo(Node o) {
        return this.weight - o.weight;
    }
}

public class Problem1 {
    public int[] shortestPath(int[][] edges, int n, int m, int src) {
        HashMap<Integer, List<int[]>> map = new HashMap<>();
        int[] min = new int[n];
        Arrays.fill(min, Integer.MAX_VALUE);
        min[src] = 0;
        for (int[] i : edges) {
            int a = i[0], b = i[1], weight = 1;
            map.computeIfAbsent(a, k -> new LinkedList<>()).add(new int[] { b, weight });
            map.computeIfAbsent(b, k -> new LinkedList<>()).add(new int[] { a, weight });
        }
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(src, src, 0));
        while (!pq.isEmpty()) {
            Node current = pq.poll();
            int currentNode = current.b;
            int currentWeight = current.weight;

            if (currentWeight > min[currentNode]) {
                continue;
            }

            List<int[]> neighbors = map.getOrDefault(currentNode, new LinkedList<>());
            for (int[] neighbor : neighbors) {
                int nextNode = neighbor[0];
                int weightToNext = neighbor[1];
                int newWeight = currentWeight + weightToNext;

                if (newWeight < min[nextNode]) {
                    min[nextNode] = newWeight;
                    pq.add(new Node(currentNode, nextNode, newWeight));
                }
            }
        }

        for (int i = 0; i < n; i++) {
            if (min[i] == Integer.MAX_VALUE) {
                min[i] = -1;
            }
        }
        return min;
    }
}
