package Step8.Lec3;

public class Problem5 {
    private double recursion(double x, int n) {
        if (n == 0) {
            return 1;
        }
        double val = recursion(x, n / 2);
        val *= val;
        return n % 2 == 0 ? val : val * x;
    }

    public double myPow(double x, int n) {
        int sign = n < 0 ? -1 : 1;
        n = Math.abs(n);
        double ans = recursion(x, n);
        return sign == -1 ? 1 / ans : ans;
    }
}