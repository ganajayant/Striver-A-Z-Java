package Step8.Lec2;

public class Problem5 {
    public int[] twoOddNum(int Arr[], int N) {
        int xor = 0;
        for (int i : Arr) {
            xor ^= i;
        }
        int num1 = 0, bit = 0;
        while ((xor & (1 << bit)) == 0) {
            bit++;
        }
        for (int i : Arr) {
            if ((i & (1 << bit)) == 0) {
                num1 ^= i;
            }
        }
        return new int[] { ((xor ^ num1) > num1) ? xor ^ num1 : num1, ((xor ^ num1) > num1) ? num1 : xor ^ num1 };
    }
}
