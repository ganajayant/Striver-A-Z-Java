package Step12.Lec2;

import java.util.LinkedList;

public class Problem9 {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        LinkedList<int[]> result = new LinkedList<>();
        int n = intervals.length;
        boolean flag = false;
        if (intervals.length == 0) {
            return new int[][] { { newInterval[0], newInterval[1] } };
        }
        if (intervals[0][0] < newInterval[0]) {
            result.add(new int[] { intervals[0][0], intervals[0][1] });
        } else {
            flag = true;
            result.add(new int[] { newInterval[0], newInterval[1] });
        }
        for (int i = flag ? 0 : 1; i < n; i++) {
            int[] last = result.getLast();
            if (!flag) {
                if (intervals[i][0] < newInterval[0]) {
                    if (last[1] >= intervals[i][0]) {
                        result.set(result.size() - 1, new int[] { last[0], Math.max(last[1], intervals[i][1]) });
                    } else {
                        result.add(new int[] { intervals[i][0], intervals[i][1] });
                    }

                } else {
                    flag = true;
                    if (last[1] >= newInterval[0]) {
                        result.set(result.size() - 1, new int[] { last[0], Math.max(last[1], newInterval[1]) });
                    } else {
                        result.add(new int[] { newInterval[0], newInterval[1] });
                    }
                    last = result.getLast();
                    if (last[1] >= intervals[i][0]) {
                        result.set(result.size() - 1, new int[] { last[0], Math.max(last[1], intervals[i][1]) });
                    } else {
                        result.add(new int[] { intervals[i][0], intervals[i][1] });
                    }
                }
            } else {
                if (last[1] >= intervals[i][0]) {
                    result.set(result.size() - 1, new int[] { last[0], Math.max(last[1], intervals[i][1]) });
                } else {
                    result.add(new int[] { intervals[i][0], intervals[i][1] });
                }
            }
        }

        if (!flag) {
            int[] last = result.getLast();
            if (last[1] >= newInterval[0]) {
                result.set(result.size() - 1, new int[] { last[0], Math.max(last[1], newInterval[1]) });
            } else {
                result.add(new int[] { newInterval[0], newInterval[1] });
            }
        }
        int m = result.size();
        int[][] newintervals = new int[m][2];
        int i = 0;
        for (int[] is : result) {
            newintervals[i++] = new int[] { is[0], is[1] };
        }
        return newintervals;
    }
}
