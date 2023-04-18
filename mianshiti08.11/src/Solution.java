class Solution {
    public int waysToChange(int n) {
        long[] dp = new long[n+1];
        dp[0] = 1;
        int[] coins = new int[] {25,10,5,1};
        for (int coin : coins) {
            for (int i = coin; i <= n; i++) {
                dp[i] += dp[i-coin];
            }
        }
        return (int) (dp[n] % 1000000007);
    }
}