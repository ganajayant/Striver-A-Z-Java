package Step3.Lec3;

import java.util.Arrays;
import java.util.LinkedList;

public class Problem7 {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> {
            return Integer.compare(a[0], b[0]);
        });
        LinkedList<int[]> result = new LinkedList<int[]>();
        for (int[] is : intervals) {
            if (result.size() == 0) {
                result.add(is);
            } else {
                int[] last = result.getLast();
                if (last[1] >= is[0]) {
                    result.set(result.size() - 1, new int[] { Math.min(last[0], is[0]), Math.max(last[1], is[1]) });
                } else {
                    result.add(is);
                }
            }
        }
        int n = result.size();
        int merged[][] = new int[n][2];
        for (int i = 0; i < merged.length; i++) {
            merged[i][0] = result.get(i)[0];
            merged[i][1] = result.get(i)[1];
        }
        return merged;
    }
}
