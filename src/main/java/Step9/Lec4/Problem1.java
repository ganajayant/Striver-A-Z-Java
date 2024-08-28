package Step9.Lec4;

import java.util.PriorityQueue;

public class Problem1 {
    class Node implements Comparable<Node> {
        int val;
        int index;

        public Node(int val, int index) {
            this.index = index;
            this.val = val;

        }

        @Override
        public int compareTo(Node o) {
            return o.val - this.val;
        }
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] result = new int[n - k + 1];
        int i = 0;
        PriorityQueue<Node> pq = new PriorityQueue<>();
        while (i < k) {
            pq.add(new Node(nums[i], i));
            i++;
        }
        result[0] = pq.peek().val;
        while (i < n) {
            while (!pq.isEmpty() && pq.peek().index <= (i - k)) {
                pq.poll();
            }
            pq.add(new Node(nums[i], i));
            result[i - k + 1] = pq.peek().val;
            i++;
        }
        return result;
    }
}
