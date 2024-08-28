package Step4.Lec3;

public class Problem4 {
    private int MaxIndex(int[][] mat, int m, int n, int mid) {
        int index = -1;
        int max = -1;
        for (int i = 0; i < m; i++) {
            if (mat[i][mid] > max) {
                max = mat[i][mid];
                index = i;
            }
        }
        return index;
    }

    public int[] findPeakGrid(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        int left = 0, right = n - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int maxRowIndex = MaxIndex(mat, m, n, mid);
            int l = mid == 0 ? -1 : mat[maxRowIndex][mid - 1];
            int r = mid == n - 1 ? -1 : mat[maxRowIndex][mid + 1];
            if (mat[maxRowIndex][mid] > l && mat[maxRowIndex][mid] > r) {
                return new int[] { maxRowIndex, mid };
            } else if (mat[maxRowIndex][mid] < l) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return new int[] { -1, -1 };
    }
}
