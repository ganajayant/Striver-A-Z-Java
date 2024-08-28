package Step12.Lec2;

public class Problem2 {
    public boolean canJump(int[] nums) {
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (max == 0) {
                return false;
            }
            max--;
            max = Math.max(max, nums[i]);
        }
        return true;
    }
}
