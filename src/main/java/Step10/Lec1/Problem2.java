package Step10.Lec1;

public class Problem2 {
    public int longestOnes(int[] nums, int k) {
        int left = 0, right = 0;
        int countzeros = 0, maxlen = 0;
        int n = nums.length;
        while (right < n) {
            if (nums[right] == 0) {
                countzeros++;
            }
            while (countzeros > k) {
                if (nums[left] == 0) {
                    countzeros--;
                }
                left++;
            }
            if (countzeros <= k) {
                maxlen = Math.max(maxlen, right - left + 1);
            }
            right++;
        }
        return maxlen;
    }
}
