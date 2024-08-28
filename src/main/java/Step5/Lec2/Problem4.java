package Step5.Lec2;

public class Problem4 {
    public int myAtoi(String s) {
        s = s.trim();
        int n = s.length();
        int sign = 1;
        int sum = 0;
        int i = 0;
        if (n == 0) {
            return 0;
        }
        if (s.charAt(i) == '-') {
            sign = -1;
            i++;
        } else if (s.charAt(i) == '+') {
            i++;
        }
        while (i < n) {
            char ch = s.charAt(i);
            if (ch < '0' || ch > '9') {
                break;
            }
            int digit = ch - '0';
            if (sign == 1 && (sum > Integer.MAX_VALUE / 10 || (sum == Integer.MAX_VALUE / 10 && digit > 7))) {
                return Integer.MAX_VALUE;
            }
            if (sign == -1 && (sum > Integer.MAX_VALUE / 10 || (sum == Integer.MAX_VALUE / 10 && digit > 8))) {
                return Integer.MIN_VALUE;
            }
            sum = sum * 10 + digit;
            i++;
        }
        return sum * sign;
    }
}
