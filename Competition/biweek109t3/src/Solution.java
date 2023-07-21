class Solution {
    public long maxScore(int[] nums, int x) {
        int n = nums.length;
        long[][] dp = new long[n][2];
        boolean[][] odd = new boolean[n][2];
        dp[0][0] = nums[0];
        odd[0][0] = nums[0]%2 == 1;
        for (int i = 1; i < n; i++) {
            boolean same = (nums[i]+nums[i-1])%2 == 0;
            //select or not
            dp[i][0] = Math.max(dp[i-1][0]+nums[i]-(same?0:x),dp[i-1][1]+nums[i]);
            odd[i][0] = nums[i]%2 == 1;
            dp[i][1] = Math.max(dp[i-1][0],dp[i-1][1]);
        }
        return Math.max(dp[n-1][0],dp[n-1][1]);
    }
}