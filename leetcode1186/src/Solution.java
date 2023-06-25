class Solution {
    public int maximumSum(int[] arr) {
        int n = arr.length;
        //dp[i][0]表示未曾删除数的最大值，dp[i][1]表示删除了数的最大值
        int[][] dp = new int[2][2];
        dp[0][0] = arr[0];
        dp[0][1] = -0x3f3f3f3f;
        int res = dp[0][0];
        for (int i = 1; i < n; i++) {
            //如果不删除数，要么从前一个加过来，要么重新记录
            dp[i%2][0] = Math.max(dp[(i-1)%2][0]+arr[i],arr[i]);
            //如果删除了数，要么从前一个已经删除过数字的结果加上当前值，要么从前一个不删除数的状态转移过来
            dp[i%2][1] = Math.max(dp[(i-1)%2][1]+arr[i],dp[(i-1)%2][0]);
            res = Math.max(res,Math.max(dp[i%2][0],dp[i%2][1]));
        }
        return res;
    }
}