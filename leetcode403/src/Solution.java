class Solution {
    public boolean canCross(int[] stones) {
        int n = stones.length;
        //dp[i][j] represents whether i can be arrived by jumped j steps
        boolean[][] dp = new boolean[n][n+1];
        if (stones[1] != 1) return false;
        dp[0][0] = dp[1][1] = true;
        for (int i = 2; i < n; i++) {
            for (int j = i-1; j >= 0; j--) {
                int diff = stones[i]-stones[j];
                if (diff >= n) break;
                //can jump from j to i
                if (dp[j][diff-1] || dp[j][diff] || dp[j][diff+1]) dp[i][diff] = true;
            }
        }
        for (int j = 0; j < n; j++) {
            if (dp[n-1][j]) return true;
        }
        return false;
    }
}