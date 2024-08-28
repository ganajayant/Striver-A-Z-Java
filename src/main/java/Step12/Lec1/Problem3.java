package Step12.Lec1;

public class Problem3 {
    static int deno[] = { 1, 2, 5, 10, 20,
            50, 100, 500, 1000 };
    static int n = deno.length;

    static int findMin(int V) {
        int res = 0;
        for (int i = n - 1; i >= 0; i--) {
            while (V >= deno[i]) {
                V -= deno[i];
                res++;
            }
        }
        return res;
    }
}
