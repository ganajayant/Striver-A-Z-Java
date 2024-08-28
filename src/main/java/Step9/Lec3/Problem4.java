package Step9.Lec3;

public class Problem4 {
    public static int[] count_NGEs(int N, int arr[], int queries, int indices[]) {
        int[] count = new int[queries];
        int i = 0;
        while (i < queries) {
            int index = indices[i];
            int val = arr[index];
            int nges = 0;
            for (int j = index + 1; j < N; j++) {
                if (arr[j] > val) {
                    nges++;
                }
            }
            count[i] = nges;
        }
        return count;
    }
}