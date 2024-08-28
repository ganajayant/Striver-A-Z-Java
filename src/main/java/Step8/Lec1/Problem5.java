package Step8.Lec1;

public class Problem5 {
    public static int countSetBits(int n) {
        int count = 0;
        for (int i = 1; i <= n; i++) {
            int temp = i;
            while (temp != 0) {
                temp = (temp & (temp - 1));
                count++;
            }
        }
        return count;
    }
}
