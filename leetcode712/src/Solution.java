class Solution {
    public int minimumDeleteSum(String s1, String s2) {
        int n1 = s1.length(),n2 = s2.length();
        //dp[i+1][j+1]表示在s1[0,i]和s2[0,j]范围内的最大公共子序列和
        //为避免单独讨论i,j为0的情况
        int[][] dp = new int[n1+1][n2+1];
        for (int i = 0; i < n1; i++) {
            char c1 = s1.charAt(i);
            for (int j = 0; j < n2; j++) {
                char c2 = s2.charAt(j);
                if (c1==c2) dp[i+1][j+1] = Math.max(dp[i+1][j+1],dp[i][j]+c1);
                else dp[i+1][j+1] = Math.max(dp[i][j+1],dp[i+1][j]);
            }
        }
        int total = 0;
        for (int i = 0; i < n1; i++) {
            total += s1.charAt(i);
        }
        for (int i = 0; i < n2; i++) {
            total += s2.charAt(i);
        }
        return total-2*dp[n1][n2];
    }
}