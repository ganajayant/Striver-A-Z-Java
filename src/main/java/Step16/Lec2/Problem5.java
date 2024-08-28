package Step16.Lec2;

public class Problem5 {
    public int rob(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length < 2) {
            return nums[0];
        }
        int[] includefirst = new int[nums.length];
        int[] excludelast = new int[nums.length];
        includefirst[0] = nums[0];
        includefirst[1] = nums[0];
        excludelast[0] = 0;
        excludelast[1] = nums[1];
        for (int i = 2; i < nums.length; i++) {
            includefirst[i] = Math.max(includefirst[i - 1], includefirst[i - 2] + nums[i]);
            excludelast[i] = Math.max(excludelast[i - 1], excludelast[i - 2] + nums[i]);
        }
        return Math.max(includefirst[nums.length - 2], excludelast[nums.length - 1]);
    }
}
