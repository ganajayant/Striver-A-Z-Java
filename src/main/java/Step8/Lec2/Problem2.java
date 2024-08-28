package Step8.Lec2;

public class Problem2 {
    public int singleNumber(int[] nums) {
        int xor = 0;
        for (int i : nums) {
            xor ^= i;
        }
        return xor;
    }
}
