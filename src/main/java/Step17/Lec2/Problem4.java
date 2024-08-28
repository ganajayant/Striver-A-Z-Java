package Step17.Lec2;

class Solution {
    public int XOR(int n, int m) {
        return n ^ m;
    }

    public int check(int a, int b) {
        return (b & (1 << (a - 1))) == 0 ? 0 : 1;
    }

    public int setBit(int c, int d) {
        return d | (1 << c);
    }
}

public class Problem4 {

}
