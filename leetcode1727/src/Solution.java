import java.util.Arrays;

class Solution {
    public int largestSubmatrix(int[][] matrix) {
        int n = matrix.length,m = matrix[0].length;
        int[][] pre = new int[n][m];
        for (int j = 0; j < m; j++) {
            pre[0][j] = matrix[0][j];
            for (int i = 1; i < n; i++) {
                if (matrix[i][j] == 1) pre[i][j] = pre[i-1][j]+1;
            }
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            Arrays.sort(pre[i]);
            for (int j = m-1; j >= 0; j--) {
                res = Math.max(res,(m-j)*pre[i][j]);
            }
        }
        return res;
    }
}