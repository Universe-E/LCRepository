import java.util.ArrayList;

class Solution {
    public int kthLargestValue(int[][] matrix, int k) {
        int n = matrix.length, m = matrix[0].length;
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i > 0) matrix[i][j] ^= matrix[i-1][j];
                if (j > 0) matrix[i][j] ^= matrix[i][j-1];
                if (i > 0 && j > 0) matrix[i][j] ^= matrix[i-1][j-1];
                list.add(matrix[i][j]);
            }
        }
        list.sort((o1,o2) -> (o2-o1));
        return list.get(k-1);
    }
}