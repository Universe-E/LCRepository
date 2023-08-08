class Solution {
    public int maxAbsoluteSum(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n][2];
        dp[0][0] = dp[0][1] = nums[0];
        int res = Math.abs(dp[0][0]);
        //find the biggest positive sum and smallest negative sum
        for (int i = 1; i < n; i++) {
            dp[i][0] = dp[i-1][0] >= 0 ? (dp[i-1][0]+nums[i]) : nums[i];
            dp[i][1] = dp[i-1][1] < 0 ? (dp[i-1][1]+nums[i]) : nums[i];
            res = Math.max(res,Math.max(Math.abs(dp[i][0]),Math.abs(dp[i][1])));
        }
        return res;
    }
}