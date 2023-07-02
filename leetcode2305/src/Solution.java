class Solution {
    public int distributeCookies(int[] cookies, int k) {
        int n = cookies.length,all = 1<<n;
        int[][] dp = new int[k][all];//dp[i][j]表示前i个孩子吃糖状态为j时的最小不公平程度
        int[] sums = new int[all];//预处理所有组合的吃糖数
        for (int i = 0; i < all; i++) {
            for (int i2 = 0; i2 < n; i2++) {
                if ((i&(1<<i2)) != 0) sums[i] += cookies[i2];
            }
        }
        System.arraycopy(sums,0,dp[0],0,all);
        for (int i = 1; i < k; i++) {
            for (int j = 0; j < all; j++) {
                dp[i][j] = 0x3f3f3f3f;
                //枚举j的子集
                for (int sub = j; sub != 0; sub = (sub-1)&j) {
                    dp[i][j] = Math.min(dp[i][j],Math.max(dp[i-1][j^sub],sums[sub]));
                }
                //第i+1个孩子吃糖状态为j，那么前i个孩子吃糖状态为(all-1)^j

            }
        }
        return dp[k-1][all-1];
    }
}

class Solution {
    public int distributeCookies(int[] cookies, int k) {
        int n = cookies.length,all = 1<<n;
        int[] dp = new int[all];//状态压缩，dp[i]吃糖状态为j时的最小不公平程度
        int[] sums = new int[all];//预处理所有组合的吃糖数
        for (int i = 0; i < all; i++) {
            for (int i2 = 0; i2 < n; i2++) {
                if ((i&(1<<i2)) != 0) sums[i] += cookies[i2];
            }
        }
        System.arraycopy(sums,0,dp,0,all);
        for (int i = 1; i < k; i++) {
            for (int j = all-1; j >= 0; j--) {
                for (int sub = j; sub != 0; sub = (sub-1)&j) {
                    dp[j] = Math.min(dp[j],Math.max(dp[j^sub],sums[sub]));
                }
                //第i+1个孩子吃糖状态为j，那么前i个孩子吃糖状态为(all-1)^j

            }
        }
        return dp[all-1];
    }
}