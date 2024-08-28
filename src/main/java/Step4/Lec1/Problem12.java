package Step4.Lec1;

public class Problem12 {
    public int singleNonDuplicate(int[] nums) {
        int n = nums.length;
        int left = 0, right = n - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (mid > 0 && nums[mid - 1] == nums[mid]) {
                if (mid % 2 == 0) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else if (mid < n - 1 && nums[mid + 1] == nums[mid]) {
                if ((mid) % 2 == 0) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            } else {
                return nums[mid];
            }
        }
        return -1;
    }
}
