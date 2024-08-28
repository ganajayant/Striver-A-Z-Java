package Step16.Lec5;

public class Problem7 {
    public String shortestCommonSupersequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        int i = m;
        int j = n;
        StringBuilder result = new StringBuilder();
        while (i > 0 && j > 0) {
            if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                result.append(text1.charAt(i - 1));
                i--;
                j--;
            } else if (dp[i - 1][j] > dp[i][j - 1]) {
                result.append(text1.charAt(i - 1));
                i--;
            } else {
                result.append(text2.charAt(j - 1));
                j--;
            }
        }
        if (i == 0 && j != 0) {
            while (j != 0) {
                result.append(text2.charAt(j - 1));
                j--;
            }
        }
        if (j == 0 && i != 0) {
            while (i != 0) {
                result.append(text1.charAt(i - 1));
                i--;
            }
        }
        return result.reverse().toString();
    }
}