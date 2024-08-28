package Step3.Lec2;

import java.util.LinkedList;
import java.util.List;

public class Problem13 {
    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int upperrow = 0, lowerrow = m - 1, leftcol = 0, rightcol = n - 1;
        LinkedList<Integer> result = new LinkedList<>();
        while (upperrow <= lowerrow && leftcol <= rightcol) {
            for (int j = leftcol; j <= rightcol; j++) {
                result.add(matrix[upperrow][j]);
            }
            upperrow++;
            for (int j = upperrow; j <= lowerrow; j++) {
                result.add(matrix[j][rightcol]);
            }
            rightcol--;
            if (upperrow <= lowerrow) {
                for (int j = rightcol; j >= leftcol; j--) {
                    result.add(matrix[lowerrow][j]);
                }
            }
            lowerrow--;
            if (leftcol <= rightcol) {
                for (int j = lowerrow; j >= upperrow; j--) {
                    result.add(matrix[j][leftcol]);
                }
            }
            leftcol++;
        }
        return result;
    }
}
