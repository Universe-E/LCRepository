import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<Integer> luckyNumbers (int[][] matrix) {
        int n = matrix.length, m = matrix[0].length;
        int[] minRow = new int[n], maxCol = new int[m];
        Arrays.fill(minRow,0x3f3f3f3f);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                minRow[i] = Math.min(minRow[i],matrix[i][j]);
                maxCol[j] = Math.max(maxCol[j],matrix[i][j]);
            }
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == minRow[i] && matrix[i][j] == maxCol[j]) list.add(matrix[i][j]);
            }
        }
        return list;
    }
}