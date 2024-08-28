package Step11.Lec3;

import java.util.HashMap;
import java.util.PriorityQueue;

public class Problem6 {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i : nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        int size = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (Integer integer : map.keySet()) {
            int value = map.get(integer);
            if (value >= k) {
                size++;
                pq.add(integer);
            }
        }
        int[] res = new int[size];
        for (int i = 0; i < res.length; i++) {
            res[i] = pq.poll();
        }
        return res;
    }
}
