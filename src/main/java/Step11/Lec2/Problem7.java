package Step11.Lec2;

import java.util.TreeMap;

public class Problem7 {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if (hand.length % groupSize != 0) {
            return false;
        }
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int i : hand) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        for (Integer key : map.keySet()) {
            int count = map.get(key);
            if (count > 0) {
                for (int i = 0; i < groupSize; ++i) {
                    if (map.getOrDefault(key + i, 0) < count) {
                        return false;
                    }
                    map.put(key + i, map.get(key + i) - count);
                }
            }
        }
        return true;
    }
}
