package Step16.Lec4;

public class Problem2 {
    boolean isSubsetSum(int N, int arr[], int sum) {
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

    public boolean canPartition(int[] nums) {
        int total_sum = 0;
        for (int i : nums) {
            total_sum += i;
        }
        if (total_sum % 2 == 1) {
            return false;
        }
        return isSubsetSum(nums.length, nums, total_sum / 2);
    }
}
