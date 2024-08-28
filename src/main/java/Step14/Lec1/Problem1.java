package Step14.Lec1;

public class Problem1 {
    static boolean isBSTTraversal(int arr[]) {
        int prev = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (prev > arr[i]) {
                return false;
            }
            prev = arr[i];
        }
        return true;
    }
}
