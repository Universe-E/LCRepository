class Solution {
    public static final int M = (int) 1e9+7;
    public int numMusicPlaylists(int n, int goal, int k) {
        int[][] dp = new int[goal+1][n+1];//dp[i][j] represents listen to i songs, includes j different songs
        dp[0][0] = 1;
        for (int i = 1; i <= goal; i++) {
            for (int j = 1; j <= n; j++) {
                //if this is a new song, calculate possible choices(n-j+1)
                //if this is an old song, cannot play the latest k songs, and the latest k songs must be distinct
                dp[i][j] = (int) (((long)dp[i-1][j-1]*(n-j+1) + (long) dp[i-1][j]*Math.max(j-k,0))%M);
            }
        }
        return dp[goal][n];
    }
}