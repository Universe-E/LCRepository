class Solution {
    public static final int M = (int) 1e9+7;
    public int ways(String[] pizza, int k) {
        int n = pizza.length, m = pizza[0].length();
        //g[i][j] represents apples from (i,j) to right-down corner
        int[][] g = new int[n+1][m+1];
        //dp[k][i][j] represents number of solutions that divide (i,j) to right-down corner into k parts
        int[][][] dp = new int[k+1][n+1][m+1];
        for (int i = n-1; i >= 0; i--) {
            for (int j = m-1; j >= 0; j--) {
                char c = pizza[i].charAt(j);
                //initialize g[i][j] and dp
                g[i][j] = g[i+1][j]+g[i][j+1]-g[i+1][j+1]+(c=='A'?1:0);
                dp[1][i][j] = g[i][j] > 0 ? 1 : 0;
            }
        }
        for (int k2 = 2; k2 <= k; k2++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    //row
                    for (int i2 = i+1; i2 < n; i2++) {
                        //every cut must be legal
                        if (g[i][j] > g[i2][j]) {
                            dp[k2][i][j] = (dp[k2][i][j]+dp[k2-1][i2][j])%M;
                        }
                    }
                    //column
                    for (int j2 = j+1; j2 < m; j2++) {
                        if (g[i][j] > g[i][j2]) {
                            dp[k2][i][j] = (dp[k2][i][j]+dp[k2-1][i][j2])%M;
                        }
                    }
                }
            }
        }
        return dp[k][0][0];
    }
}