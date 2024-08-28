package Step4.Lec2;

import java.util.Arrays;

public class Problem10 {
    private boolean check(int[] nums, int k, int mid) {
        int student = 1;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > mid) {
                return false;
            }
            if (sum + nums[i] > mid) {
                student++;
                sum = nums[i];
                if (student > k) {
                    return false;
                }
            } else {
                sum += nums[i];
            }
        }
        return true;
    }

    public int splitArray(int[] nums, int k) {
        int left = Arrays.stream(nums).max().getAsInt();
        int right = Arrays.stream(nums).sum();
        int result = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (check(nums, k, mid)) {
                result = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return result;
    }
}
