package Step15.Lec4;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Problem10 {
    class Node {
        int currentNumber;
        int steps;

        public Node(int currentNumber, int steps) {
            this.currentNumber = currentNumber;
            this.steps = steps;
        }
    }

    int minimumMultiplications(int[] arr, int start, int end) {
        Queue<Node> pq = new LinkedList<>();
        int[] distance = new int[100_000];
        if (start == end) {
            return 0;
        }
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[start] = 0;
        pq.add(new Node(start, 0));
        int n = arr.length;
        while (!pq.isEmpty()) {
            Node temp = pq.poll();
            for (int i = 0; i < n; i++) {
                int num = (temp.currentNumber * arr[i]) % 100_000;
                if (temp.steps + 1 < distance[num]) {
                    distance[num] = temp.steps + 1;
                    if (num == end) {
                        return temp.steps + 1;
                    }
                    pq.add(new Node(num, temp.steps + 1));
                }
            }
        }
        return -1;
    }
}
