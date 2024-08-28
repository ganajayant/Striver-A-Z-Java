package Step3.Lec1;

public class Problem11 {
    public int findMaxConsecutiveOnes(int[] nums) {
        int count = 0;
        int maxcount = 0;
        for (int i : nums) {
            if (i == 1) {
                count++;
                maxcount = Math.max(maxcount, count);
            } else {
                count = 0;
            }
        }
        return maxcount;
    }
}
