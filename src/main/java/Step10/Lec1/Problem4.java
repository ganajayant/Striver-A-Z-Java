package Step10.Lec1;

public class Problem4 {
    public int characterReplacement(String s, int k) {
        int n = s.length();
        int left = 0, right = 0;
        int maxlen = 0, maxfreq = 0;
        int[] freq = new int[26];
        while (right < n) {
            freq[s.charAt(right) - 'A']++;
            maxfreq = Math.max(maxfreq, freq[s.charAt(right) - 'A']);
            while ((right - left + 1) - maxfreq > k) {
                freq[s.charAt(left++) - 'A']--;
                for (int i : freq) {
                    maxfreq = Math.max(maxfreq, i);
                }
            }
            if ((right - left + 1) - maxfreq <= k) {
                maxlen = Math.max(maxlen, (right - left + 1));
            }
            right++;
        }
        return maxlen;
    }
}
