package Step3.Lec3;

public class Problem12 {
    public int maxProduct(int[] nums) {
        int n = nums.length, max = Integer.MIN_VALUE, prefix = 1, suffix = 1;
        for (int i = 0; i < n; i++) {
            prefix *= nums[i];
            suffix *= nums[n - i - 1];
            max = Math.max(max, Math.max(prefix, suffix));
        }
        return max;
    }
}
