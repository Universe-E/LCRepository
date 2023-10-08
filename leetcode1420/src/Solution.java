class Solution {
    private static final int M = (int) 1e9+7;
    public int numOfArrays(int n, int m, int k) {
        if (k > m || k == 0) return 0;
        //dp[i][j][p]表示前i个数，最大值为j，cost为p时符合条件的数组总数
        int[][][] dp = new int[n+1][m+1][k+1];
        //对于i个数全为1的情况
        for (int i = 1; i <= n; i++) {
            dp[i][1][1] = 1;
        }
        //对于只有j一个数的情况
        for (int j = 1; j <= m; j++) {
            dp[1][j][1] = 1;
        }
        for (int i = 2; i <= n; i++) {
            for (int p = 1; p <= k; p++) {
                int sum = 0;
                for (int j = 2; j <= m; j++) {
                    sum = (sum+dp[i-1][j-1][p-1])%M;
                    dp[i][j][p] = (int) (((long)dp[i-1][j][p]*j+sum)%M);
                }
            }
        }
        int res = 0;
        for (int j = 1; j <= m; j++) {
            res = (res+dp[n][j][k])%M;
        }
        return res;
    }
}