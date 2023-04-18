import java.util.Arrays;

class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) return nums[0];
        int[] dp = new int[n];
        //rob i=0
        dp[0] = nums[0];
        //dp[i] 表示从[0,i]的最大收益
        for (int i = 1; i < n-1; i++) {
            //find dp[i]
            for (int j = 0; j <= i; j++) {
                dp[i] = Math.max(dp[i],nums[j] + ((j-2)>=0 ? dp[j-2] : 0));
            }
        }
        int temp = Math.max(n>=3 ? dp[n-3] : 0,dp[n-2]);// n-1 and 0 are adjacent, so dp[n-1] equals to dp[n-3]
        //reset dp, this time not rob i=0
        Arrays.fill(dp,0);
        for (int i = 1; i < n; i++) {
            //find dp[j], start from 1, because 0 should not be robbed
            for (int j = 1; j <= i; j++) {
                dp[i] = Math.max(dp[i],nums[j] + ((j-2)>=0 ? dp[j-2] : 0));
            }
        }
        return Math.max(temp,dp[n-1]);
    }
}