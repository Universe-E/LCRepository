class Solution {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        //选用第一行和第一列作为标记行列，遍历一遍数组
        boolean row = false,col = false;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    if (i == 0) row = true;
                    if (j == 0) col = true;
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        //随后，从[1,1]开始，决定每一行列是否要置零
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][0] == 0) for (int k = 1; k < n; k++) matrix[i][k] = 0;
                if (matrix[0][j] == 0) for (int k = 1; k < m; k++) matrix[k][j] = 0;
            }
        }
        //最后，判断第一行和第一列是否要置零
        if (row) for (int i = 0; i < n; i++) matrix[0][i] = 0;
        if (col) for (int i = 0; i < m; i++) matrix[i][0] = 0;
    }
}