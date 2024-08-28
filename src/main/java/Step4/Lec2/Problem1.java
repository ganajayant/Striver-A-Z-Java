package Step4.Lec2;

public class Problem1 {

    long floorSqrt(long x) {
        if (x == 1) {
            return x;
        }
        long left = 0, right = x - 1;
        while (left <= right) {
            long mid = left + (right - left) / 2;
            long square = mid * mid;
            if (square == (long) x) {
                return mid;
            } else if (square < (long) x) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return Math.round(right);
    }
}
