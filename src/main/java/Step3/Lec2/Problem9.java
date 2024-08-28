package Step3.Lec2;

import java.util.ArrayList;

public class Problem9 {
    public static ArrayList<Integer> leaders(int arr[], int n) {
        int[] result = new int[n];
        result[n - 1] = arr[n - 1];
        int max = result[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            max = Math.max(max, arr[i]);
            result[i] = max;
        }
        ArrayList<Integer> leaders = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (arr[i] >= result[i]) {
                leaders.add(arr[i]);
            }
        }
        return leaders;
    }
}
