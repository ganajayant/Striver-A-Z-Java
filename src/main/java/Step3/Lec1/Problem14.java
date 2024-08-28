package Step3.Lec1;

import java.util.TreeMap;

public class Problem14 {
    public static int lenOfLongSubarr(int A[], int N, int K) {
        TreeMap<Integer, Integer> hm = new TreeMap<>();
        int sum = 0, maxlen = 0;
        for (int i = 0; i < A.length; i++) {
            sum += A[i];
            if (sum == K) {
                maxlen = Math.max(maxlen, i + 1);
            }
            int rem = sum - K;
            if (hm.containsKey(rem)) {
                int len = i - hm.get(rem);
                maxlen = Math.max(maxlen, len);
            }
            if (!hm.containsKey(sum)) {
                hm.put(sum, i);
            }
        }
        return maxlen;
    }
}
