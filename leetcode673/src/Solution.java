import java.util.Arrays;

class Solution {
    public int findNumberOfLIS(int[] nums) {
        int n = nums.length,longest = 1;
        int[] dp = new int[n],c = new int[n];
        Arrays.fill(dp,1);
        Arrays.fill(c,1);
        for (int i = 1; i < n; i++) {
            for (int j = i-1; j >= 0; j--) {
                if (nums[j] < nums[i]) {
                    //find longer subsequence
                    if (dp[j]+1 > dp[i]) {
                        dp[i] = dp[j]+1;
                        c[i] = c[j];//renew c[i]
                    }
                    //find the same longest subsequence
                    //eg: current length is 4, find j where dp[j]=3, in this case c[i] add c[j]
                    else if (dp[j]+1 == dp[i]) c[i] += c[j];
                }
            }
            longest = Math.max(longest,dp[i]);
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            if (dp[i] == longest) res += c[i];
        }
        return res;
    }
}