package Step7.Lec1;

public class Problem3 {

    int mod = 1000000007;

    public int countGoodNumbers(long n) {
        long first = n % 2 == 0 ? n / 2 : n / 2 + 1;
        long second = n / 2;
        return (int) (pow(5, first) * pow(4, second) % mod);
    }

    private long pow(long x, long n) {
        if (n == 0) {
            return 1;
        }
        long val = pow(x, n / 2);
        val = val * val % mod;
        return n % 2 == 0 ? val : val * x % mod;
    }
}
