package Step16.Lec4;

public class Problem3 {
    private int recursion(int[] nums, int current_sum, int total_sum, int index, int count_elements, int n) {
        if (count_elements == n) {
            return Math.abs((total_sum - current_sum) - current_sum);
        }
        if (index == 2 * n) {
            return Integer.MAX_VALUE;
        }
        return Math.min(recursion(nums, current_sum + nums[index], total_sum, index + 1, count_elements + 1, n),
                recursion(nums, current_sum, total_sum, index + 1, count_elements, n));
    }

    public int minimumDifference(int[] nums) {
        int sum = 0;
        for (int i : nums) {
            sum += i;
        }
        int n = nums.length / 2;
        return recursion(nums, 0, sum, 0, 0, n);
    }
}
