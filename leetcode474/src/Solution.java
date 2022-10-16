class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        int len = strs.length;
        int[][] dp = new int[m + 1][n + 1];
        dp[0][0] = 0;
        for (int i = 1; i <= len; i++) {
            String str = strs[i - 1];
            int c0 = 0,c1 = 0;
            for (int j = 0; j < str.length(); j++) {
                if (str.charAt(j) == '0') c0++;
                else c1++;
            }
            for (int j = m; j >= 0; j--) {
                for (int k = n; k >= 0; k--) {
                    if (j >= c0 && k >= c1) dp[j][k] = Math.max(dp[j][k],1 + dp[j - c0][k - c1]);
                }
            }
        }
        return dp[m][n];
    }
    //注意：回溯肯定超时
//    private void backTrack(String[] strs,int m,int n,int p,int target) {
//        for (int i = p; i < strs.length; i++) {
//            String str = strs[i];
//            int c0 = 0,c1 = 0;
//            for (int j = 0; j < str.length(); j++) {
//                if (str.charAt(j) == '0') c0++;
//                else c1++;
//            }
//            if (c0 > m || c1 > n) continue;
//            target++;
//            backTrack(strs,m-c0,n-c1,i+1,target);
//            target--;
//        }
//        res = Math.max(res,target);
//    }
}