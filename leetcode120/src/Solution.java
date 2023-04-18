import java.util.List;

class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[][] dp = new int[n][n];
        dp[0][0] = triangle.get(0).get(0);
        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                dp[i][j] = (j==0 ? dp[i-1][j] : j==i ? dp[i-1][j-1] : Math.min(dp[i-1][j-1],dp[i-1][j])) + triangle.get(i).get(j);
            }
        }
        int res = 0x3f3f3f3f;
        for (int i = 0; i < n; i++) {
            res = Math.min(res,dp[n-1][i]);
        }
        return res;
    }
}