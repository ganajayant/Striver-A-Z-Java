package Step10.Lec1;

import java.util.HashSet;

public class Problem1 {
    public int lengthOfLongestSubstring(String s) {
        int left = 0, right = 0;
        HashSet<Character> set = new HashSet<>();
        int max = 0;
        int n = s.length();
        while (right < n) {
            char ch = s.charAt(right);
            while (set.contains(ch)) {
                set.remove(s.charAt(left));
                left++;
            }
            set.add(s.charAt(right));
            max = Math.max(max, (right - left + 1));
            right++;
        }
        return max;
    }
}
