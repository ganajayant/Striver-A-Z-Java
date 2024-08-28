package Step5.Lec1;

public class Problem7 {
    public boolean isAnagram(String s, String t) {
        int[] map = new int[26];
        for (char ch : s.toCharArray()) {
            map[ch - 'a']++;
        }
        for (char ch : t.toCharArray()) {
            map[ch - 'a']--;
            if (map[ch - 'a'] < 0) {
                return false;
            }
        }
        for (int i : map) {
            if (i != 0) {
                return false;
            }
        }
        return true;
    }
}
