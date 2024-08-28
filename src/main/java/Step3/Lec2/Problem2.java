package Step3.Lec2;

public class Problem2 {
    public void sortColors(int[] nums) {
        int[] colors = new int[3];
        for (int i : nums) {
            colors[i]++;
        }
        int i = 0, index = 0;
        while (i < 3 && index < nums.length) {
            if (colors[i] == 0) {
                i++;
            } else {
                nums[index++] = i;
                colors[i]--;
            }
        }
        return;
    }
}
