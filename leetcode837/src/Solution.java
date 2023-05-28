class Solution {
    public double new21Game(int n, int k, int maxPts) {
        double[] dp = new double[k+maxPts];
        double s = 0;
        for(int i = k; i<k+maxPts; ++i) {
            dp[i] = i<=n? 1 : 0;
            s += dp[i];
        }
        for(int i = k-1; i>=0; --i) {
            dp[i] = s/maxPts;
            s = s - dp[i+maxPts] + dp[i];
        }
        return dp[0];
    }
}