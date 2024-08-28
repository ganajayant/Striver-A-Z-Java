package Step4.Lec1;

public class Problem7 {
    int count(int[] nums, int n, int target) {
        int left = 0, right = nums.length - 1;
        int leftoccurence = -1, rightoccurence = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] <= target) {
                if (nums[mid] == target) {
                    rightoccurence = mid;
                }
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        left = 0;
        right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] >= target) {
                if (nums[mid] == target) {
                    leftoccurence = mid;
                }
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        if (leftoccurence == -1 || rightoccurence == -1) {
            return 0;
        }
        return leftoccurence - rightoccurence + 1;
    }
}
