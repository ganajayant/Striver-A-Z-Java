package Step7.Lec2;

import java.util.LinkedList;
import java.util.List;

public class Problem3 {
    List<List<Integer>> result;

    private void recursion(int[] nums, int i, List<Integer> temp) {
        if (i == nums.length) {
            result.add(temp);
            return;
        }
        List<Integer> x = new LinkedList<>(temp);
        x.add(nums[i]);
        recursion(nums, i + 1, x);
        recursion(nums, i + 1, new LinkedList<>(temp));
    }

    public List<List<Integer>> subsets(int[] nums) {
        result = new LinkedList<>();
        recursion(nums, 0, new LinkedList<>());
        return result;
    }
}
