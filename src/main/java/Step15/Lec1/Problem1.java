package Step15.Lec1;

public class Problem1 {
    static long count(int n) {
        long complete = ((n) * (n - 1)) / 2;
        return (long) Math.pow(2, complete);
    }
}
