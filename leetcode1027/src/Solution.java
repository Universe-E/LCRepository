import java.util.Arrays;

class Solution {
    public int longestArithSeqLength(int[] nums) {
        int n = nums.length;
        //每个dp[i]表示[-500,500]的公差范围
        //为方便起见，对于第i个元素，公差为d的最大等差数列长度表示为dp[i][d+500]
        int[][] dp = new int[n][1001];
        //初始值均为1
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i],1);
        }
        int res = 1;
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                //对于每一个nums[j]，得到公差为nums[j]-nums[i]
                //索引为nums[j]-nums[i]+500
                int idx = nums[j]-nums[i]+500;
                dp[j][idx] = dp[i][idx]+1;
                res = Math.max(res,dp[j][idx]);
            }
        }
        return res;
    }
}