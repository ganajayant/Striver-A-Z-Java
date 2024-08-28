package Step4.Lec2;

import java.util.Arrays;

public class Problem6 {
    private boolean check(int[] weights, int days, int weight) {
        int count = 1;
        int temp = 0;
        for (int i : weights) {
            if (temp + i <= weight) {
                temp += i;
            } else {
                count++;
                temp = i;
            }
        }
        return count <= days;
    }

    public int shipWithinDays(int[] weights, int days) {
        int left = Arrays.stream(weights).max().getAsInt(), right = Arrays.stream(weights).sum();
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (check(weights, days, mid)) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}
