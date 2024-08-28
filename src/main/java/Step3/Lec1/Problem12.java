package Step3.Lec1;

public class Problem12 {
    public int singleNumber(int[] nums) {
        int xor = 0;
        for (int i : nums) {
            xor ^= i;
        }
        return xor;
    }
}
