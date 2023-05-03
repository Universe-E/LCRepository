class Solution {
    public static final int M = (int)1e9 + 7;
    public int numberOfArrays(String s, int k) {
        int n = s.length();
        //处理s字符串
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = s.charAt(i) - '0';
        }
        //dp[i]表示[0,i]的选择方案数
        //dp[i] = ∑j dp[j-1]（arr[i] > 0）
        //dp[i] = dp[i-1] (arr[i] = 0)
        int[] dp = new int[n];
        long cur = arr[0];
        if (cur > k) return 0;
        dp[0] = 1;
        for (int i = 1; i < n; i++) {
            cur = 0;
            //由于k最大为1e9，i和j相距不会超过10
            for (int j = i; j >= 0 && i-j <= 10; j--) {
                if (arr[j] == 0) continue;
                cur += arr[j] * (long)Math.pow(10,i-j);
                if (cur > k) break;
                dp[i] = (dp[i] + (j==0 ? 1 : dp[j-1]))%M;
            }
        }
        return dp[n-1];
    }
}