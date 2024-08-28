package Step3.Lec2;

public class Problem12 {
    public void rotate(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = i; j < matrix[0].length; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        for (int[] is : matrix) {
            int i = 0, j = is.length - 1;
            while (i < j) {
                int temp = is[i];
                is[i++] = is[j];
                is[j--] = temp;
            }
        }
        return;
    }
}
