class Solution {
    public int minDistance(String word1, String word2) {
        int n1 = word1.length(),n2 = word2.length();
        int[][] dp = new int[n1 + 1][n2 + 1];
        //初始化dp
        for (int i = 0; i <= n1; i++) dp[i][0] = i;
        for (int i = 0; i <= n2; i++) dp[0][i] = i;
        for (int i = 1; i <= n1; i++) {
            for (int j = 1; j <= n2; j++) {
                //如果字母相同，不需要操作
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) dp[i][j] = dp[i - 1][j - 1];
                //否则在增，删，改里面选一个最小的，其中，“改”其实就是先增后删
                else dp[i][j] = Math.min(dp[i - 1][j] + 1,Math.min(dp[i][j - 1] + 1,dp[i - 1][j - 1] + 1));
            }
        }
        return dp[n1][n2];
    }
}