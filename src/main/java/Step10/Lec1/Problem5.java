package Step10.Lec1;

import java.util.HashMap;

public class Problem5 {
    public int numSubarraysWithSum(int[] nums, int goal) {
        int sum = 0, result = 0;
        HashMap<Integer, Integer> preSum = new HashMap<>();
        preSum.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (preSum.containsKey(sum - goal)) {
                result += preSum.get(sum - goal);
            }
            preSum.put(sum, preSum.getOrDefault(sum, 0) + 1);
        }
        return result;
    }
}