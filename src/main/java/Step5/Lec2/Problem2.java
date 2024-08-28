package Step5.Lec2;

public class Problem2 {
    public int maxDepth(String s) {
        int opencount = 0;
        int max = 0;
        int i = 0, n = s.length() - 1;
        while (i < n) {
            char ch = s.charAt(i);
            if (ch == '(') {
                opencount++;
                max = Math.max(opencount, max);
            } else if (ch == ')') {
                opencount--;
            }
            i++;
        }
        return max;
    }
}
