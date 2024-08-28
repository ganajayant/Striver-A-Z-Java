package Step16.Lec4;

public class Problem1 {
    static Boolean isSubsetSum(int N, int arr[], int sum) {
        boolean[][] memo = new boolean[N + 1][sum + 1];
        for (int i = 0; i <= N; i++) {
            memo[i][0] = true;
        }
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= sum; j++) {
                if (arr[i - 1] <= j) {
                    memo[i][j] = memo[i - 1][j - arr[i - 1]] || memo[i - 1][j];
                } else {
                    memo[i][j] = memo[i - 1][j];
                }
            }
        }
        return memo[N][sum];
    }
}
