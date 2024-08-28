package Step12.Lec2;

public class Problem3 {
    public int jump(int[] nums) {
        int count = 0, index = 0, n = nums.length;
        int maxreach = 0, currentend = 0;
        while (index < n - 1) {
            maxreach = Math.max(maxreach, nums[index] + index);
            if (index == currentend) {
                currentend = maxreach;
                count++;
            }
            index++;
        }
        return count;
    }
}
