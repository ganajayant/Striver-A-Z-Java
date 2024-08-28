package Step16.Lec2;

public class Problem4 {

    public int rob(int[] nums) {
        int a = 0;
        int b = 0;
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            if (i % 2 == 0) {
                a = Math.max(a + nums[i], b);
            } else {
                b = Math.max(a, b + nums[i]);
            }
        }
        return Math.max(a, b);
    }

}
