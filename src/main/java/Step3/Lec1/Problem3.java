package Step3.Lec1;

public class Problem3 {
    public boolean check(int[] nums) {
        int n = nums.length;
        int count = 0;
        for (int i = 1; i < n; i++) {
            if (nums[i - 1] > nums[i]) {
                count++;
            }
            if (count > 1) {
                return false;
            }
        }
        return count == 1 ? nums[n - 1] <= nums[0] : true;
    }
}
