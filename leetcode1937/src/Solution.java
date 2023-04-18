class Solution {
    public long maxPoints(int[][] points) {
        int m = points.length, n = points[0].length;
        long[][] dp = new long[m][n];
        //先处理第一行
        for (int i = 0; i < n; i++) {
            dp[0][i] = points[0][i];
        }
        //从第二行开始，设每一行第j个点的最大左部偏移量为lMax,最大右部偏移量为rMax
        for (int i = 1; i < m; i++) {
            long lMax = Long.MIN_VALUE,rMax = Long.MIN_VALUE;
            for (int j = 0; j < n; j++) {
                //先考虑每个元素相对于j=0时的左部偏移量为j，找到包含偏移量之后最大的lMax
                lMax = Math.max(lMax,dp[i-1][j] + j);
                dp[i][j] = Math.max(dp[i][j],points[i][j] + lMax - j);
                //同理，每个元素相对于j=n-1的右部偏移量为n-1-j，找到包含偏移量之后最大的rMax
                rMax = Math.max(rMax,dp[i-1][n-1-j] -n+1+j);
                dp[i][n-1-j] = Math.max(dp[i][n-1-j],points[i][n-1-j] + rMax +n-1-j);
            }
        }
        long res = 0;
        for (int i = 0; i < n; i++) {
            res = Math.max(res,dp[m-1][i]);
        }
        return res;
    }
}