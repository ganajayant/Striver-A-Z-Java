package Step16.Lec2;

public class Problem2 {
    public int minimumEnergy(int arr[], int N) {
        if (N == 1) {
            return 0;
        }
        int prev2 = 0;
        int prev1 = Math.abs(arr[1] - arr[0]);
        for (int i = 2; i < N; i++) {
            int jumpOneStep = Math.abs(arr[i] - arr[i - 1]) + prev1;
            int jumpTwoSteps = Math.abs(arr[i] - arr[i - 2]) + prev2;
            int curr = Math.min(jumpOneStep, jumpTwoSteps);
            prev2 = prev1;
            prev1 = curr;
        }
        return prev1;
    }
}
