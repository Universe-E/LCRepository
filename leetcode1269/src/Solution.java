class Solution {
    public static final int M = (int)1e9+7;
    public int numWays(int steps, int arrLen) {
        //最远可能到达的索引记为max
        int max = Math.min(steps/2,arrLen-1);
        //dp[i][j]表示执行i次操作后，到达位置j的方案数，最远可以到达max
        //由dp数组定义，二维数组长度分别设置为steps+1和max+1
        int[][] dp = new int[steps+1][max+1];
        //初始值为1
        dp[0][0] = 1;
        //每个点只能由上一步的左（向右）、中（不动）、右（向左）三个点到达，可以得出如下转移方程：
        //dp[i][j] = dp[i-1][j-1] + dp[i-1][j] + dp[i-1][j+1]
        for (int i = 1; i <= steps; i++) {
            //每走一步，都更新一下dp数组，看看第i步各点的方案数
            for (int j = 0; j <= max; j++) {
                //注意边界，j=0处没有左值，j=max处没有右值
                dp[i][j] = ((dp[i-1][j] + (j==0?0:dp[i-1][j-1]))%M + (j==max?0:dp[i-1][j+1]))%M;
            }
        }
        return dp[steps][0];
    }
}