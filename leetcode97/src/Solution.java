class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) return false;
        int n1 = s1.length(),n2 = s2.length();
        boolean[][] dp = new boolean[n1 + 1][n2 + 1];
        dp[0][0] = true;
        //dp[i][j]表示s1[0:i - 1]和s2[0:j - 1]能否组成s3[0:i + j - 1]
        for (int i = 1; i < n1 + 1; i++) {
            if (s1.charAt(i - 1) == s3.charAt(i - 1)) dp[i][0] = true;
            else break;
        }
        for (int i = 1; i < n2 + 1; i++) {
            if (s2.charAt(i - 1) == s3.charAt(i - 1)) dp[0][i] = true;
            else break;
        }
        for (int i = 1; i < n1 + 1; i++) {
            for (int j = 1; j < n2 + 1; j++) {
                dp[i][j] = (dp[i - 1][j] && s1.charAt(i - 1) == s3.charAt(i + j - 1)) ||
                        (dp[i][j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1));
            }
        }
        return dp[n1][n2];
    }
}