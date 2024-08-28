package Step8.Lec2;

public class Problem4 {
    private static int xor(int n) {
        if (n % 4 == 1) {
            return 1;
        } else if (n % 4 == 2) {
            return n + 1;
        } else if (n % 4 == 3) {
            return 0;
        } else {
            return n;
        }
    }

    public static int findXOR(int l, int r) {
        int left = xor(l - 1);
        int right = xor(r);
        return left ^ right;
    }
}
