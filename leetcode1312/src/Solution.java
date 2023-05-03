class Solution {
    public int minInsertions(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];//dp[i][j]表示s[i,j]的最长回文子序列长度
        for (int i = n-1; i >= 0; i--) {
            dp[i][i] = 1;
            for (int j = i+1; j < n; j++) {
                if (s.charAt(i) == s.charAt(j)) dp[i][j] = dp[i+1][j-1]+2;
                else dp[i][j] = Math.max(dp[i+1][j],dp[i][j-1]);
            }
        }
        return n - dp[0][n-1];
    }
}

class Solution {
    public int minInsertions(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];//dp[i][j]表示使得s[i,j]成为回文串的最小插入次数
        for (int i = n-1; i >= 0; i--) {
            for (int j = i+1; j < n; j++) {
                if (s.charAt(i) == s.charAt(j)) dp[i][j] = dp[i+1][j-1];
                else dp[i][j] = Math.min(dp[i+1][j],dp[i][j-1])+1;
            }
        }
        return dp[0][n-1];
    }
}