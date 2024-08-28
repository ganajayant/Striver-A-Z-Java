package Step4.Lec3;

public class Problem2 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        int top = 0, bottom = m - 1;
        int start = -1;
        while (top <= bottom) {
            int mid = top + (bottom - top) / 2;
            if (matrix[mid][0] <= target && matrix[mid][n - 1] >= target) {
                if (matrix[mid][0] == target || matrix[mid][n - 1] == target) {
                    return true;
                }
                start = mid;
                break;
            } else if (matrix[mid][0] < target) {
                top = mid + 1;
            } else {
                bottom = mid - 1;
            }
        }
        if (start == -1) {
            return false;
        }
        int[] searchrow = matrix[start];
        int left = 0, right = n - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (searchrow[mid] == target) {
                return true;
            } else if (searchrow[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return false;
    }
}
