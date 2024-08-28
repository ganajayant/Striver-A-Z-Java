package Step4.Lec2;

import java.util.ArrayList;

public class Problem9 {
    private static boolean check(ArrayList<Integer> arr, int n, int m, int mid) {
        int student = 1;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            if (arr.get(i) > mid) {
                return false;
            }
            if (sum + arr.get(i) > mid) {
                student++;
                sum = arr.get(i);
                if (student > m) {
                    return false;
                }
            } else {
                sum += arr.get(i);
            }
        }
        return true;
    }

    public static int findPages(ArrayList<Integer> arr, int n, int m) {
        if (n < m) {
            return -1;
        }
        int min = arr.stream().max(Integer::compare).get();
        int max = arr.stream().mapToInt(Integer::intValue).sum();
        int left = min, right = max;
        int result = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (check(arr, n, m, mid)) {
                result = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return result;
    }
}
