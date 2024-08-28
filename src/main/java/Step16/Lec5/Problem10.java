package Step16.Lec5;

public class Problem10 {
    private boolean recursion(String s, String p, int i, int j, Boolean[][] dp) {
        if (j < 0) {
            return i < 0;
        }
        if (i < 0 && j >= 0) {
            for (int k = 0; k <= j; k++) {
                if (p.charAt(k) != '*') {
                    return false;
                }
            }
            return true;
        }
        if (dp[i][j] != null) {
            return dp[i][j];
        }
        if (s.charAt(i) == p.charAt(j) || p.charAt(j) == '?') {
            dp[i][j] = recursion(s, p, i - 1, j - 1, dp);
        } else if (p.charAt(j) == '*') {
            dp[i][j] = recursion(s, p, i - 1, j, dp) || recursion(s, p, i, j - 1, dp);
        } else {
            dp[i][j] = false;
        }
        return dp[i][j];
    }

    public boolean isMatch(String s, String p) {
        int m = s.length(), n = p.length();
        Boolean[][] dp = new Boolean[m][n];
        return recursion(s, p, m - 1, n - 1, dp);
    }
}
