package Step5.Lec2;

public class Problem7 {
    public int beautySum(String s) {
        int n = s.length();
        int ans = 0;
        for (int i = 0; i < n; i++) {
            int[] count = new int[26];
            for (int j = i; j < n; j++) {
                count[s.charAt(j) - 'a']++;
                int max = Integer.MIN_VALUE;
                int min = Integer.MAX_VALUE;
                for (int element : count) {
                    max = Math.max(max, element);
                    if (element != 0) {
                        min = Math.min(min, element);
                    }
                }
                ans += max - min;
            }
        }
        return ans;
    }
}
