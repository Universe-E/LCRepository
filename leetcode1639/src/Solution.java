class Solution {
    public static final int M = (int)1e9+7;
    public int numWays(String[] words, String target) {
        int m = words[0].length(),tn = target.length();
        int[][] cnt = new int[m][26];//第m列每个字符的出现频率
        for (String word : words) {
            for (int j = 0; j < m; j++) {
                char c = word.charAt(j);
                cnt[j][c - 'a']++;
            }
        }
        int[][] dp = new int[m][tn];//dp[i][j]表示words前i列匹配target前j位的方案数
        //dp[i][j] = dp[i-1][j] + dp[i-1][j-1]*cnt[i][target.charAt(j)-'a']
        dp[0][0] = cnt[0][target.charAt(0)-'a'];
        for (int i = 1; i < m; i++) {
            dp[i][0] = dp[i-1][0] + cnt[i][target.charAt(0)-'a'];
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < tn; j++) {
                dp[i][j] = (dp[i-1][j] + (int) ((long)dp[i-1][j-1]*cnt[i][target.charAt(j)-'a']%M))%M;
            }
        }
        return dp[m-1][tn-1];
    }
}