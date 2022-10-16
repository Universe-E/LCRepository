class Solution {
    public int jump(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = 0;
        for (int i = 0; i < n - 1; i++) {
            int times = dp[i];//设置跳跃次数
            for (int j = i + 1; j <= i + nums[i] && j < n; j++) {
                if (dp[j] == 0) dp[j] = times + 1;
            }
        }
        return dp[n - 1];
    }
}
