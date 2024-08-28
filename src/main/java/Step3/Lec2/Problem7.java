package Step3.Lec2;

public class Problem7 {
    public int[] rearrangeArray(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        int postiveIndex = 0, negativeIndex = 1;
        for (int i = 0; i < n; i++) {
            if (nums[i] > 0) {
                result[postiveIndex] = nums[i];
                postiveIndex += 2;
            } else {
                result[negativeIndex] = nums[i];
                negativeIndex += 2;
            }
        }
        return result;
    }
}
