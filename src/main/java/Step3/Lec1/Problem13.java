package Step3.Lec1;

public class Problem13 {
    public static int lenOfLongSubarr(int A[], int N, int K) {
        int left = 0, right = 0;
        int sum = A[0], maxlen = 0;
        while (right < N) {
            while (left <= right && sum > K) {
                sum -= A[left];
                left++;
            }
            if (sum == K) {
                maxlen = Math.max(maxlen, right - left + 1);
            }
            right++;
            if (right < N) {
                sum += A[right];
            }
        }
        return maxlen;
    }
}
