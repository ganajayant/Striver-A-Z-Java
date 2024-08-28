package Step3.Lec2;

public class Problem5 {
    public int maxSubArray(int[] nums) {
        int sum = 0;
        int MaxSum = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            MaxSum = Math.max(MaxSum, sum);
            if (sum < 0) {
                sum = 0;
            }
        }
        return MaxSum;
    }
}
