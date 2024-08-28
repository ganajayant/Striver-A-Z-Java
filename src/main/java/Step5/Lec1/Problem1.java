package Step5.Lec1;

public class Problem1 {
    public String removeOuterParentheses(String s) {
        int opencount = 0;
        String result = "";
        int i = 0, n = s.length();
        while (i < n) {
            if (s.charAt(i) == '(') {
                result += opencount == 0 ? "" : "(";
                opencount++;
            } else {
                result += opencount > 1 ? ")" : "";
                opencount--;
            }
            i++;
        }
        return result;
    }
}
