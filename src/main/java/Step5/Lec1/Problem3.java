package Step5.Lec1;

public class Problem3 {
    public String largestOddNumber(String num) {
        int n = num.length();
        int i = n - 1;
        while (i >= 0) {
            char ch = num.charAt(i);
            int digit = ch - '0';
            if (digit % 2 == 1) {
                return num.substring(0, i + 1);
            }
            i--;
        }
        return "";
    }
}
