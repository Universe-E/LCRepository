import java.util.Arrays;

class Solution {
    public int largest1BorderedSquare(int[][] grid) {
        //分别计算右侧和下侧连续值的最小值，以及左侧和上侧连续值的最小值
        int m = grid.length, n = grid[0].length;
        int[][] l = new int[m][n], r = new int[m][n], d = new int[m][n], u = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int i2 = m-i-1,j2 = n-j-1;
                if (j == 0) {
                    r[i][j] = grid[i][j];
                    l[i][j2] = grid[i][j2];
                }
                else {
                    if (grid[i][j] == 0) r[i][j] = 0;
                    else r[i][j] = r[i][j-1] + 1;
                    if (grid[i][j2] == 0) l[i][j2] = 0;
                    else l[i][j2] = l[i][j2+1] + 1;
                }
                if (i == 0) {
                    d[i][j] = grid[i][j];
                    u[i2][j] = grid[i2][j];
                }
                else {
                    if (grid[i][j] == 0) d[i][j] = 0;
                    else d[i][j] = d[i-1][j] + 1;
                    if (grid[i2][j] == 0) u[i2][j] = 0;
                    else u[i2][j] = u[i2+1][j] + 1;
                }
            }
        }
        //声明正方形边长
        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                //从对角线开始找，k决定每个点能找多远距离
                for (int k = 0; k < Math.min(l[i][j],u[i][j]); k++) {
                    if (Math.min(r[i+k][j+k],d[i+k][j+k]) > k) res = Math.max(res,k+1);
                }
            }
        }
        return res*res;
    }
}