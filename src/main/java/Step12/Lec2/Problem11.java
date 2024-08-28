package Step12.Lec2;

import java.util.Arrays;

public class Problem11 {
    public int eraseOverlapIntervals(int[][] intervals) {
        int n = intervals.length;
        if (n == 0) {
            return 0;
        }
        Arrays.sort(intervals, (a, b) -> {
            return a[0] - b[0];
        });
        int count = 1;
        int end = intervals[0][1];
        for (int i = 1; i < n; i++) {
            if (intervals[i][0] >= end) {
                count++;
                end = intervals[i][1];
            }
        }
        return n - count;
    }
}
