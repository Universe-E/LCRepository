class Solution {
    public boolean validPartition(int[] nums) {
        int n = nums.length;
        boolean[] dp = new boolean[n+1];//dp[i+1]表示[0,i]是否可以被成功划分
        dp[0] = true;
        for (int i = 1; i < n; i++) {
            if (nums[i] == nums[i-1] && dp[i-1]) dp[i+1] = true;
            if (i > 1) {
                if (nums[i] == nums[i-1] && nums[i] == nums[i-2] && dp[i-2]) dp[i+1] = true;
                if (nums[i] == nums[i-1]+1 && nums[i] == nums[i-2]+2 && dp[i-2]) dp[i+1] = true;
            }
        }
        return dp[n];
    }
}