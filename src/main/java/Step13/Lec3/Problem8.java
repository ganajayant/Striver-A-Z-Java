package Step13.Lec3;

public class Problem8 {
    public static boolean isPossible(int a, int b) {
        return !(a == b || (a == 1 && b == 3) || (a == 3 && b == 1));
    }
}
