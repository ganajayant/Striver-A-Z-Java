package Step11.Lec2;

import java.util.PriorityQueue;

public class Problem5 {
    static class Node implements Comparable<Node> {
        int data;
        int index;

        public Node(int data, int index) {
            this.data = data;
            this.index = index;
        }

        @Override
        public int compareTo(Node o) {
            return this.data - o.data;
        }

    }

    static int[] replaceWithRank(int arr[], int N) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            pq.add(new Node(arr[i], i));
        }
        int rank = 1;
        Node prev = null;
        while (!pq.isEmpty()) {
            Node curr = pq.poll();
            if (prev == null) {
                arr[curr.index] = rank;
            } else if (prev.data == curr.data) {
                arr[curr.index] = rank;
            } else {
                rank++;
                arr[curr.index] = rank;
            }
            prev = curr;
        }
        return arr;
    }
}
