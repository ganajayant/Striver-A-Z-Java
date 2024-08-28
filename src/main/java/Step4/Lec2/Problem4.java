package Step4.Lec2;

import java.util.Arrays;

public class Problem4 {
    private boolean check(int[] bloomDay, int required, int slide, int day) {
        int count = 0;
        int total = 0;
        for (int i = 0; i < bloomDay.length; i++) {
            if (bloomDay[i] <= day) {
                count++;
            } else {
                total += (count / slide);
                count = 0;
            }
        }
        total += (count / slide);
        return total >= required;
    }

    public int minDays(int[] bloomDay, int m, int k) {
        long val = (long) m * k;
        int n = bloomDay.length;
        if (val > n) {
            return -1;
        }
        int max = Arrays.stream(bloomDay).max().getAsInt();
        int min = Arrays.stream(bloomDay).min().getAsInt();
        int left = min, right = max;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (check(bloomDay, m, k, mid)) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}
