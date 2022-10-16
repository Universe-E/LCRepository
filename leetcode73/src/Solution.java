import java.util.Arrays;

class Solution {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int[] columns = new int[n];
        for (int[] ints : matrix) {
            boolean zero = false;
            for (int j = 0; j < n; j++) {
                if (ints[j] == 0) {
                    columns[j] = 1;
                    zero = true;
                }
            }
            if (zero) Arrays.fill(ints,0);
        }
        for (int i = 0; i < n; i++) {
            if (columns[i] == 1) {
                for (int j = 0; j < m; j++) {
                    matrix[j][i] = 0;
                }
            }
        }
    }
}
