package Step3.Lec3;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class Problem3 {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new LinkedList<>();
        HashSet<List<Integer>> hs = new HashSet<>();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int target = -1 * nums[i];
            int l = i + 1;
            int r = n - 1;
            while (l < r) {
                int sum = nums[l] + nums[r];
                if (sum == target) {
                    hs.add(Arrays.asList(-1 * target, nums[l++], nums[r--]));
                } else if (sum < target) {
                    l++;
                } else {
                    r--;
                }
            }
        }
        result.addAll(hs);
        return result;
    }
}
