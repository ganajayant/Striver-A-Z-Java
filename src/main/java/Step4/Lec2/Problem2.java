package Step4.Lec2;

public class Problem2 {
    public int NthRoot(int n, int m) {
        if (n == 1 || m == 1) {
            return m;
        }
        long left = 0, right = m - 1;
        while (left <= right) {
            long mid = left + (right - left) / n;
            long mutli = 1;
            int temp = n;
            while (temp-- > 0) {
                mutli *= mid;
            }
            if (mutli == (long) m) {
                return (int) mid;
            } else if (mutli < (long) m) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return Math.round(right);
    }
}
