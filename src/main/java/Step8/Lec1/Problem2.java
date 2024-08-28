package Step8.Lec1;

public class Problem2 {
    static boolean checkKthBit(int n, int k) {
        return ((n & 1 << (k - 1)) >> (k - 1)) == 1;
    }
}
