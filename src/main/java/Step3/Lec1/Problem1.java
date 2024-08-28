package Step3.Lec1;

public class Problem1 {
    public int largest(int arr[], int n) {
        int max = Integer.MIN_VALUE;
        for (int i : arr) {
            max = Math.max(max, i);
        }
        return max;
    }
}
