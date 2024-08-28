package Step11.Lec2;

import java.util.Collections;
import java.util.PriorityQueue;

public class Problem1 {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int integer : nums) {
            pq.add(integer);
        }
        while (k-- > 1) {
            pq.poll();
        }
        return pq.peek();
    }
}
