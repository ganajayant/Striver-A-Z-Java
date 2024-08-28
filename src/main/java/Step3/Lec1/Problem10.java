package Step3.Lec1;

public class Problem10 {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int sum = n * (n + 1) / 2;
        int currentsum = 0;
        for (int i : nums) {
            currentsum += i;
        }
        return sum - currentsum;
    }
}