import java.util.Arrays;

class Solution {
    public static final int inf = 0x3f3f3f3f;
    public int minimizeConcatenatedLength(String[] words) {
        int n = words.length;
        int res = inf;
        int[][][] dp = new int[n][26][26];//dp[i][j][k]表示第i个str首尾分别为j,k时的最短长度
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 26; j++) {
                Arrays.fill(dp[i][j], inf);
            }
        }
        dp[0][words[0].charAt(0)-'a'][words[0].charAt(words[0].length()-1)-'a'] = words[0].length();
        for (int i = 1; i < n; i++) {
            int pre = words[i].charAt(0)-'a',suf = words[i].charAt(words[i].length()-1)-'a',len = words[i].length();
            for (int j = 0; j < 26; j++) {
                for (int k = 0; k < 26; k++) {
                    //首尾分别为pre和k，此时words[i]在左，如果之前的j和suf相同，则减1
                    dp[i][pre][k] = Math.min(dp[i][pre][k],dp[i-1][j][k]+len-(suf==j?1:0));
                    //首尾分别为j和suf，此时words[i]在右，如果之前的k和pre相同，则减1
                    dp[i][j][suf] = Math.min(dp[i][j][suf],dp[i-1][j][k]+len-(k==pre?1:0));
                }
            }
        }
        for (int j = 0; j < 26; j++) {
            for (int k = 0; k < 26; k++) {
                res = Math.min(res,dp[n-1][j][k]);
            }
        }
        return res;
    }
}