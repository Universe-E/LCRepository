import java.util.Arrays;

class Solution {
    private static final int M = (int) 1e9+7;
    public int countVowelPermutation(int n) {
        //dp[i][0-5] represents count of permutation end with a,e,i,o,u respectively
        int[][] dp = new int[n][5];
        Arrays.fill(dp[0],1);
        for (int i = 1; i < n; i++) {
            dp[i][0] = (int) (((long) dp[i-1][1]+dp[i-1][2]+dp[i-1][4])%M);
            dp[i][1] = (int) (((long) dp[i-1][0]+dp[i-1][2])%M);
            dp[i][2] = (int) (((long) dp[i-1][1]+dp[i-1][3])%M);
            dp[i][3] = (int) (((long) dp[i-1][2])%M);
            dp[i][4] = (int) (((long) dp[i-1][2]+dp[i-1][3])%M);
        }
        return (int) (((long)dp[n-1][0]+dp[n-1][1]+dp[n-1][2]+dp[n-1][3]+dp[n-1][4])%M);
    }
}