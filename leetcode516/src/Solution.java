class Solution {
    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];
        //dp[i][j]表示从[i,j]区间内的最大回文子序列
        for (int i = n-1; i >= 0; i--) {
            dp[i][i] = 1;//对于单个字符
            char c = s.charAt(i);
            for (int j = i+1; j < n; j++) {
                char c2 = s.charAt(j);
                //满足条件则扩增
                if (c == c2) dp[i][j] = dp[i+1][j-1] + 2;
                //否则i和j不可能同时作为首尾，从两个最长子序列取最优解
                else dp[i][j] = Math.max(dp[i+1][j],dp[i][j-1]);
            }
        }
        return dp[0][n-1];
    }
}