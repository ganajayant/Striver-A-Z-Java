package Step4.Lec2;

public class Problem3 {
    private boolean check(int[] piles, int h, int k) {
        int sum = 0;
        for (int j : piles) {
            sum += Math.ceilDiv(j, k);
            if (sum > h) {
                return false;
            }
        }
        return sum <= h;
    }

    private int max(int[] piles) {
        int max = Integer.MIN_VALUE;
        for (int i : piles) {
            max = Math.max(max, i);
        }
        return max;
    }

    public int minEatingSpeed(int[] piles, int h) {
        int left = 1, right = max(piles);
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (check(piles, h, mid)) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}
