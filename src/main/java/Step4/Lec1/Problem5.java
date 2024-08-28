package Step4.Lec1;

public class Problem5 {
    public static int[] getFloorAndCeil(int[] a, int n, int x) {
        int floor = Integer.MIN_VALUE;
        int ceil = Integer.MAX_VALUE;
        int left = 0, right = n - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (a[mid] <= x) {
                if (a[mid] == x) {
                    floor = x;
                    break;
                }
                if (a[mid] < x && floor <= a[mid]) {
                    floor = a[mid];
                }
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        left = 0;
        right = n - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (a[mid] >= x) {
                if (a[mid] == x) {
                    ceil = x;
                    break;
                }
                if (a[mid] > x && ceil >= a[mid]) {
                    ceil = a[mid];
                }
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return new int[] { floor == Integer.MIN_VALUE ? -1 : floor, ceil == Integer.MAX_VALUE ? -1 : ceil };

    }
}
