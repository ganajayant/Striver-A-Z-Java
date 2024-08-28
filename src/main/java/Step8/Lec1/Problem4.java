package Step8.Lec1;

public class Problem4 {
    public boolean isPowerOfTwo(int n) {
        return (n & (n - 1)) == 0;
    }
}
