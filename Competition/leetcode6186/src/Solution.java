import java.util.Arrays;

class Solution {
    public int[] smallestSubarrays(int[] nums) {
        int n = nums.length;
        int[] dp = new int[32];
        Arrays.fill(dp, -1);
        int[] res = new int[n];
        //从后往前遍历，如果当前值在某二进制位出现了1，则让该二进制位标上当前值的序号，
        //如果当前二进制位已更新过，所有位最远的位置即为当前二进制位最后一次更新所在索引与当前索引距离之差，对应最大按位或数组长度
        for (int i = n - 1; i >= 0; i--) {
            int max = 1;
            for (int j = 0; j < 32; j++) {
                if (((nums[i] >> j) & 1) == 1) {
                    dp[j] = i;
                }
                if (dp[j] != -1) {
                    max = Math.max(max, dp[j] - i + 1);
                }
            }
            res[i] = max;
        }
        return res;
    }
}