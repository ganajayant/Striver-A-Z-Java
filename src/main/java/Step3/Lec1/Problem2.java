package Step3.Lec1;

public class Problem2 {
    public int print2largest(int arr[], int n) {
        int max = Integer.MIN_VALUE / 2;
        int secondmax = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (i == 0) {
                max = arr[i];
            }
            if (arr[i] > max) {
                secondmax = max;
                max = arr[i];
            } else if (max > arr[i] && arr[i] > secondmax) {
                secondmax = arr[i];
            }
        }
        return secondmax == Integer.MIN_VALUE ? -1 : secondmax;
    }
}
