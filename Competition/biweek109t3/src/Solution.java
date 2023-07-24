class Solution {
    public static final long inf = Long.MAX_VALUE/2;
    public long maxScore(int[] nums, int x) {
        int n = nums.length;
        long[][] dp = new long[n][2];//dp[i][0] represents even result where dp[i][1] represents odd
        for (int i = 0; i < n; i++) {
            dp[i][0] = dp[i][1] = -inf;
        }
        dp[0][nums[0]%2] = nums[0];
        for (int i = 1; i < n; i++) {
            int odd = nums[i]%2;
            if (odd == 0) {
                dp[i][0] = Math.max(dp[i-1][0]+nums[i],dp[i-1][1]+nums[i]-x);
                dp[i][1] = dp[i-1][1];
            }
            else {
                dp[i][0] = dp[i-1][0];
                dp[i][1] = Math.max(dp[i-1][0]+nums[i]-x,dp[i-1][1]+nums[i]);
            }
        }
        return Math.max(dp[n-1][0],dp[n-1][1]);
    }
}