package Step16.Lec3;

import java.util.HashMap;
import java.util.List;

public class Problem5 {
    private int f(List<List<Integer>> triangle, int hindex, int height, int i, HashMap<String, Integer> map) {
        if (hindex == height) {
            return 0;
        }
        String key = (Integer.toString(hindex) + "$" + Integer.toString(i));
        if (map.containsKey(Integer.toString(hindex) + "$" + Integer.toString(i))) {
            return map.get(Integer.toString(hindex) + "$" + Integer.toString(i));
        }
        int min = triangle.get(hindex).get(i) + f(triangle, hindex + 1, height, i, map);
        if (i + 1 < triangle.get(hindex).size()) {
            min = Math.min(min, triangle.get(hindex).get(i + 1) + f(triangle, hindex + 1, height, i + 1, map));
        }
        map.put(key, min);
        return min;
    }

    public int minimumTotal(List<List<Integer>> triangle) {
        int height = triangle.size();
        return f(triangle, 0, height, 0, new HashMap<>());
    }
}
