package Step15.Lec5;

class GfG {
    int find(int A[], int X) {
        if (A[X] == X) {
            return X;
        }
        return A[X] = find(A, A[X]);
    }

    void unionSet(int A[], int X, int Z) {
        int UlitmateX = find(A, X);
        int UlitmateZ = find(A, Z);
        if (UlitmateX == UlitmateZ) {
            return;
        }
        A[UlitmateX] = UlitmateZ;
    }
}

public class Problem3 {

}
