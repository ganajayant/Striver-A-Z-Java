package Step4.Lec1;

class Pair {
    int ceil, floor;

    public Pair(int ceil, int floor) {
        this.ceil = ceil;
        this.floor = floor;
    }
}

public class Problem3 {
    Pair getFloorAndCeil(int[] arr, int n, int x) {
        int floor = Integer.MIN_VALUE, ceil = Integer.MAX_VALUE;
        for (int i : arr) {
            if (floor <= i && i <= x) {
                floor = i;
            }
            if (ceil >= i && i >= x) {
                ceil = i;
            }
        }
        return new Pair(floor == Integer.MIN_VALUE ? -1 : floor, ceil == Integer.MAX_VALUE ? -1 : ceil);
    }
}
