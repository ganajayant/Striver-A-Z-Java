package Step11.Lec2;

import java.util.PriorityQueue;

public class Problem2 {
    public static int kthSmallest(int[] arr, int l, int r, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i : arr) {
            pq.add(i);
        }
        while (k-- > 1) {
            pq.poll();
        }
        return pq.peek();
    }
}
