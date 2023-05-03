class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int n = arr.length;
        int[] dp = new int[n+1];//dp[i]表示arr[0,i-1]的最大结果
        for (int i = 1; i <= n; i++) {
            int max = 0;
            for (int j = i-1; j >= Math.max(0,i-k); j--) {
                max = Math.max(max,arr[j]);
                dp[i] = Math.max(dp[i],dp[j] + max*(i-j));
            }
        }
        return dp[n];
    }
}