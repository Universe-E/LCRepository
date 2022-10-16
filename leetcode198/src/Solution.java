class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = nums[0];
        //注意一定要缕清，dp[i]不代表一定要从i开始偷，只是说截止到i的最佳结果
        //例： [4,3,2,9]
        // dp[0] = 0
        // dp[1] = 4，偷nums[0]
        // dp[2] = max(4,0+3) = 4，dp[2]是从dp[1]过来的，这里不偷nums[1]
        // dp[3] = max(4,4+2) = 6，第一个4是从dp[2]过来的，本质上还是从dp[1]来的，所以不用担心2与3相邻的影响
        // dp[4] = max(6,4+9) = 13，按照以上分析：dp[4]->dp[3]->dp[2]->dp[1]=4，再加上9
        for (int i = 2; i <= n; i++) {
            dp[i] = Math.max(dp[i - 1],dp[i - 2] + nums[i - 1]);
        }
        return dp[n];
    }
}
