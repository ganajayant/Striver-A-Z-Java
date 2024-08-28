package Step5.Lec1;

import java.util.TreeMap;

public class Problem5 {
    public boolean isIsomorphic(String s, String t) {
        TreeMap<Character, Character> map1 = new TreeMap<>();
        TreeMap<Character, Character> map2 = new TreeMap<>();
        int n = s.length();
        for (int i = 0; i < n; ++i) {
            char a = s.charAt(i), b = t.charAt(i);
            if (map1.containsKey(a) && map1.get(a) != b) {
                return false;
            }
            if (map2.containsKey(b) && map2.get(b) != a) {
                return false;
            }
            map1.put(a, b);
            map2.put(b, a);
        }
        return true;
    }
}
