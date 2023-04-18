import java.util.Arrays;

class Solution {
    public int minCost(int[] nums, int k) {
        int n = nums.length;
        //dp[i+1]表示划分nums前i个数的最小代价
        int[] dp = new int[n+1];
        //对于每一个i，从i开始倒序枚举最后一个子数组的开始位置j，记录每一个i对应的唯一元素个数，记为unique
        //state[i] = 0表示未出现，此时unique++; state[i] = 1表示出现1次，此时unique--，state[i] = 2表示出现2次及以上
        byte[] state = new byte[n];
        //dp[i+1] = min(dp[j]) + i-j+1+k-unique
        for (int i = 0; i < n; i++) {
            Arrays.fill(state, (byte) 0);
            int unique = 0, cur = Integer.MAX_VALUE;
            for (int j = i; j >= 0; j--) {
                //当前元素未曾出现过，则unique自增，state[nums[j]]置为1
                if (state[nums[j]] == 0) {
                    unique++;
                    state[nums[j]] = 1;
                }
                //当前元素出现过一次，则unique自减，state[nums[j]]置为2
                else if (state[nums[j]] == 1) {
                    unique--;
                    state[nums[j]] = 2;
                }
                cur = Math.min(cur,dp[j]+i-j+1+k-unique);
            }
            dp[i+1] = cur;
        }
        return dp[n];
    }

}