class Solution {
    public int maxSumSubmatrix(int[][] matrix, int k) {
        int m = matrix.length, n = matrix[0].length;
        int[][] temp = new int[m][n];
        //记录每一列截止到i的和
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0) temp[i][j] = matrix[i][j];
                else temp[i][j] = matrix[i][j] + temp[i - 1][j];
            }
        }
        //记录temp中每一行截止到j的和，这样temp2[i][j]就代表矩阵从[0,0]到[i - 1,j - 1]的总和
        int[][] temp2 = new int[m + 1][n + 1];
        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if (j == 1) temp2[i][j] = temp[i - 1][j - 1];
                else temp2[i][j] = temp[i - 1][j - 1] + temp2[i][j - 1];
            }
        }
        int res = Integer.MIN_VALUE;
        for (int i = 1; i < m + 1; i++) {
            for (int j = 0; j < i; j++) {
                for (int l = 1; l < n + 1; l++) {
                    for (int o = 0; o < l; o++) {
                        int cur = temp2[i][l] - temp2[i][o] - (temp2[j][l] - temp2[j][o]);
                        if (cur <= k) res = Math.max(res, cur);
                    }
                }
            }
        }
        return res;
    }
}