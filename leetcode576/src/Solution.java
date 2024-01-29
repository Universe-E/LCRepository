class Solution {
    int n,m;
    private static final int[] d = new int[] {1,0,-1,0,1};
    private boolean inArea(int i,int j) {
        return i >= 0 && i < m && j >= 0 && j < n;
    }
    private static final int M = (int) 1e9+7;
    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        this.n = n;
        this.m = m;
        //dp[i][j][k] means the number of paths at (j,k) after moving i times
        int[][][] dp = new int[maxMove+1][m][n];
        dp[0][startRow][startColumn] = 1;
        int res = 0;
        for (int i = 0; i < maxMove; i++) {
            if (i > 0) {
                for (int j = 0; j < m; j++) {
                    for (int k = 0; k < n; k++) {
                        for (int l = 0; l < 4; l++) {
                            int j2 = j+d[l],k2 = k+d[l+1];
                            if (inArea(j2,k2)) dp[i][j][k] = (dp[i][j][k]+dp[i-1][j2][k2])%M;
                        }
                    }
                }
            }
            for (int j = 0; j < m; j++) {
                res = (res + dp[i][j][0]) % M;
                res = (res + dp[i][j][n - 1]) % M;
            }
            for (int k = 0; k < n; k++) {
                res = (res+dp[i][0][k])%M;
                res = (res+dp[i][m-1][k])%M;
            }
        }
        return res;
    }
}