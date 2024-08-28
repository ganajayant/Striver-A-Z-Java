package Step3.Lec3;

import java.util.HashMap;

public class Problem5 {
    public int maxLen(int arr[], int n) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int sum = 0, len = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if (sum == 0) {
                len = Math.max(len, i + 1);
            }
            if (map.containsKey(sum)) {
                len = Math.max(len, i - map.get(sum));
            }
            if (!map.containsKey(sum)) {
                map.put(sum, i);
            }
        }
        return len;
    }
}
