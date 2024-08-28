package Step7.Lec2;

import java.util.LinkedList;
import java.util.List;

public class Problem2 {
    List<String> result;

    private void recursion(String s, int open, int totalopen, int n) {
        if (s.length() == 2 * n) {
            result.add(s);
            return;
        } else {
            if (open == 0) {
                recursion(s + "(", open + 1, totalopen + 1, n);
            } else {
                if (totalopen < n) {
                    recursion(s + "(", open + 1, totalopen + 1, n);
                }
                recursion(s + ")", open - 1, totalopen, n);
            }
        }
    }

    public List<String> generateParenthesis(int n) {
        result = new LinkedList<>();
        recursion("", 0, 0, n);
        return result;
    }
}
