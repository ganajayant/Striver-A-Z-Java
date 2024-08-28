package Step11.Lec2;

import java.util.ArrayList;

public class Problem3 {
    public static ArrayList<Integer> mergeKArrays(int[][] arr, int K) {
        ArrayList<Integer> result = new ArrayList<>();
        int m = arr.length;
        int[] KPointers = new int[m];
        while (true) {
            int min = Integer.MAX_VALUE;
            int minIndex = -1;
            for (int i = 0; i < m; i++) {
                if (KPointers[i] < K && arr[i][KPointers[i]] < min) {
                    min = arr[i][KPointers[i]];
                    minIndex = i;
                }
            }
            if (minIndex == -1) {
                break;
            }
            result.add(min);
            KPointers[minIndex]++;
        }
        return result;
    }
}
