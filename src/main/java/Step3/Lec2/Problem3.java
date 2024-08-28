package Step3.Lec2;

public class Problem3 {
    public int majorityElement(int[] nums) {
        int count = 1;
        int element = nums[0];
        int n = nums.length;
        for (int i = 1; i < n; i++) {
            if (element != nums[i]) {
                count--;
            } else {
                count++;
            }
            if (count <= 0) {
                element = nums[i];
                count = 1;
            }
        }
        count = 0;
        for (int i : nums) {
            if (element == i) {
                count++;
            }
        }
        return count > n / 2 ? element : -1;
    }
}
