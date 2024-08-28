package Step4.Lec2;

import java.util.Arrays;

public class Problem8 {
    private static boolean check(int[] stalls, int cows, int distance) {
        int n = stalls.length;
        int count = 1;
        int prev = stalls[0];
        for (int i = 1; i < n; i++) {
            if (stalls[i] - prev >= distance) {
                count++;
                prev = stalls[i];
            }
            if (count >= cows) {
                return true;
            }
        }
        return false;
    }

    public static int aggressiveCows(int[] stalls, int k) {
        Arrays.sort(stalls);
        int n = stalls.length;
        int left = 0, right = stalls[n - 1] - stalls[0];
        int ans = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (check(stalls, k, mid)) {
                ans = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return ans;
    }
}
