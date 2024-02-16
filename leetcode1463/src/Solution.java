import java.util.Arrays;

class Solution {
    public int cherryPickup(int[][] grid) {
        int n = grid.length,m = grid[0].length;
        int[][][] dp = new int[2][m][m];
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < m; j++) {
                Arrays.fill(dp[i][j],-1);
            }
        }
        dp[0][0][m-1] = grid[0][0] + grid[0][m-1];
        for (int i = 1; i < n; i++) {
            for (int j1 = 0; j1 < m; j1++) {
                for (int j2 = 0; j2 < m; j2++) {
                    for (int k1 = Math.max(0,j1-1); k1 <= Math.min(m-1,j1+1); k1++) {
                        for (int k2 = Math.max(0,j2-1); k2 <= Math.min(m-1,j2+1); k2++) {
                            if (dp[(i-1)%2][k1][k2] == -1) continue;
                            dp[i%2][j1][j2] = Math.max(dp[i%2][j1][j2],
                                    dp[(i-1)%2][k1][k2]+(j1==j2 ? grid[i][j1] : (grid[i][j1]+grid[i][j2])));
                        }
                    }
                }
            }
        }
        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                res = Math.max(res,dp[(n-1)%2][i][j]);
            }
        }
        return res;
    }
}