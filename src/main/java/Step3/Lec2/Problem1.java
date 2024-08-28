package Step3.Lec2;

import java.util.TreeMap;

public class Problem1 {
    public int[] twoSum(int[] nums, int target) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[] { i, map.get(target - nums[i]) };
            }
            map.put(nums[i], i);
        }
        return new int[] { -1, -1 };
    }
}
