package Step3.Lec2;

import java.util.TreeMap;

public class Problem14 {
    public int subarraySum(int[] A, int K) {
        TreeMap<Integer, Integer> hm = new TreeMap<>();
        hm.put(0, 1);
        int sum = 0, result = 0;
        for (int i = 0; i < A.length; i++) {
            sum += A[i];
            int rem = sum - K;
            if (hm.containsKey(rem)) {
                result += hm.get(rem);
            }
            hm.put(sum, hm.getOrDefault(sum, 0) + 1);
        }
        return result;
    }
}
