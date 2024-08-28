package Step10.Lec1;

import java.util.HashMap;

public class Problem3 {
    public static int totalFruits(int N, int[] fruits) {
        int maxlen = 0;
        int left = 0, right = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        while (right < N) {
            map.put(fruits[right], map.getOrDefault(fruits[right], 0) + 1);
            while (map.size() > 2) {
                int fruit = (fruits[left]);
                int count = map.get(fruit);
                if (count == 1) {
                    map.remove(fruit);
                } else {
                    map.put(fruit, count - 1);
                }
                left++;
            }
            maxlen = Math.max(maxlen, right - left + 1);
            right++;
        }
        return maxlen;
    }
}
