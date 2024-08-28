package Step3.Lec1;

public class Problem8 {
    public static int searchInSorted(int arr[], int N, int K) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == K) {
                return 1;
            }
        }
        return -1;
    }
}
