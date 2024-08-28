package Step3.Lec3;

public class Problem9 {
    public int[] findTwoElement(int arr[], int n) {
        long sum = 0;
        long squaresum = 0;
        long actualsum = n * (n + 1) / 2;
        long actualsqauresum = actualsum * (2 * n + 1) / 3;
        for (int i : arr) {
            sum += i;
            squaresum += (long) i * (long) i;
        }
        long val1 = actualsum - sum;
        long val2 = actualsqauresum - squaresum;
        val2 = val2 / val1;
        long x = (val1 + val2) / 2;
        long y = x - val1;
        return new int[] { (int) y, (int) x };
    }
}
