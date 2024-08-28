package Step8.Lec1;

import java.util.Arrays;
import java.util.List;

public class Problem7 {
    static List<Integer> get(int a, int b) {
        a = a ^ b;
        b = b ^ a;
        a = a ^ b;
        return Arrays.asList(a, b);
    }
}
