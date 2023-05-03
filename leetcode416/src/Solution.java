class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 != 0) return false;
        boolean[] dp = new boolean[sum/2 + 1];//dp[i]表示是否能够分割成大小为i的子集
        dp[0] = true;
        for (int num : nums) {
            for (int j = sum / 2; j >= num; j--) {
                dp[j] |= dp[j - num];
                if (dp[sum/2]) return true;
            }
        }
        return false;
    }
}