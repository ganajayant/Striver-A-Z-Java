package Step4.Lec1;

public class Problem13 {
    public int findPeakElement(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return 0;
        }
        int left = 0, right = n - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (mid == 0) {
                if (nums[0] > nums[1]) {
                    return mid;
                } else {
                    left = mid + 1;
                }
            }
            if (mid == n - 1) {
                if (nums[n - 1] > nums[n - 2]) {
                    return mid;
                } else {
                    right = mid - 1;
                }
            }
            if (mid > 0 && mid < n - 1) {
                if (nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1]) {
                    return mid;
                }
                if (nums[mid + 1] > nums[mid - 1]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }
}
