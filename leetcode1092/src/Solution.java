class Solution {
    public String shortestCommonSupersequence(String str1, String str2) {
        int m = str1.length(), n = str2.length();
        //先找最长公共子序列，再逐次插入
        //dp[i][j]表示字符串 str1 的前 i 个字符和字符串 str2 的前 j 个字符的最长公共子序列的长度
        int[][] dp = new int[m+1][n+1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (str1.charAt(i-1) == str2.charAt(j-1)) dp[i][j] = dp[i-1][j-1] + 1;
                else dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
            }
        }
        StringBuilder sb = new StringBuilder();
        //从后往前插入
        int i = m,j = n;
        while (i > 0 || j > 0) {
            if (i == 0) sb.append(str2.charAt(--j));
            else if (j == 0) sb.append(str1.charAt(--i));
            else {
                if (dp[i][j] == dp[i-1][j]) sb.append(str1.charAt(--i));
                else if (dp[i][j] == dp[i][j-1]) sb.append(str2.charAt(--j));
                else {
                    sb.append(str1.charAt(--i));
                    --j;
                }
            }
        }
        return sb.reverse().toString();
    }
}