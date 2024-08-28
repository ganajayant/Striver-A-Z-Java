package Step7.Lec2;

import java.util.LinkedList;
import java.util.List;

public class Problem1 {
    LinkedList<String> result;

    private void buildstring(String s, int k) {
        if (s.length() == k) {
            result.add(s);
            return;
        }
        if (s.length() == 0) {
            buildstring(s + "0", k);
            buildstring(s + "1", k);
        } else {
            if (s.charAt(s.length() - 1) == '1') {
                buildstring(s + "0", k);
            } else {
                buildstring(s + "0", k);
                buildstring(s + "1", k);
            }
        }
    }

    public List<String> buildstring(int k) {
        result = new LinkedList<>();
        buildstring("", k);
        return result;
    }
}
