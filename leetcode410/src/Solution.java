import java.util.Arrays;

class Solution {
    public static final int inf = 0x3f3f3f3f;
    public int splitArray(int[] nums, int k) {
        int n = nums.length;
        //dp[i+1][j] represents the minimized largest sum from [0,i] when split j times
        int[][] dp = new int[n+1][k+1];
        int[] pre = new int[n+1];
        for (int i = 0; i <= n; i++) {
            Arrays.fill(dp[i],inf);
            if (i != 0) pre[i] = pre[i-1]+nums[i-1];
        }
        dp[0][0] = 0;
        //enumerate i
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= Math.min(k,i); j++) {
                for (int l = 0; l < i; l++) {
                    int cur = pre[i]-pre[l];
                    dp[i][j] = Math.min(dp[i][j],Math.max(dp[l][j-1],cur));
                }
            }
        }
        return dp[n][k];
    }
}