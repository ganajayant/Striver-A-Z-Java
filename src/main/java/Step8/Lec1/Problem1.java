package Step8.Lec1;

public class Problem1 {
    static void bitManipulation(int num, int i) {
        int x = (num & 1 << (i - 1)) >> (i - 1);
        int y = (num | 1 << (i - 1));
        int z = (num & ~(1 << (i - 1)));
        System.out.println(x + " " + y + " " + z);
    }
}