package Step3.Lec1;

import java.util.Arrays;

public class Problem7 {
    public void moveZeroes(int[] nums) {
        int i = 0;
        int n = nums.length;
        for (int j = 0; j < n; j++) {
            if (nums[j] != 0) {
                nums[i++] = nums[j];
            }
        }
        Arrays.fill(nums, i, n, 0);
        return;
    }
}
