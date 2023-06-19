class Solution {
    public int maxSumDivThree(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n][3];//dp[i][j]表示前i个数，模3=j时的最大值
        dp[0][nums[0]%3] = nums[0];
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < 3; j++) {
                //先将上一个状态转移过来
                dp[i][j] = Math.max(dp[i][j],dp[i-1][j]);
                //转移每个模3=j的数
                int sum = dp[i-1][j]+nums[i];
                dp[i][sum%3] = Math.max(dp[i][sum%3],sum);
            }
        }
        return dp[n-1][0];
    }
}