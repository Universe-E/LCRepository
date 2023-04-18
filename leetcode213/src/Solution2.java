import java.util.Arrays;

public class Solution2 {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) return nums[0];
        int[] dp = new int[n];
        //rob i=0
        dp[0] = nums[0];
        dp[1] = dp[0];
        for (int i = 2; i < n; i++) {
            dp[i] = Math.max(dp[i-1],dp[i-2] + nums[i]);
        }
        int t = Math.max(dp[n-2],n>=3 ? dp[n-3] : 0);
        Arrays.fill(dp,0);
        //not rob i=0
        dp[1] = nums[1];
        for (int i = 2; i < n; i++) {
            dp[i] = Math.max(dp[i-1],dp[i-2] + nums[i]);
        }
        return Math.max(dp[n-1],t);
    }
}
