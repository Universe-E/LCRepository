class Solution {
    public int maxScore(int[] nums) {
        int n = nums.length;
        int[][] gcds = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                gcds[i][j] = gcd(nums[i],nums[j]);
            }
        }
        int[] dp = new int[1 << n];
        for (int k = 0; k < 1 << n; k++) {
            int cnt = Integer.bitCount(k);
            //判断当前二进制状态下1的个数是否为偶数，是的话枚举1所在的两个位置，设为i和j，对i,j进行操作，此时获得的分数为(cnt/2)*gcds[i][j]
            if (cnt%2==0) {
                for (int i = 0; i < n; i++) {
                    if (((k>>i) & 1) == 1) {
                        for (int j = i+1; j < n; j++) {
                            if (((k>>j)&1) == 1) {
                                dp[k] = Math.max(dp[k],cnt/2*gcds[i][j] + dp[k^(1<<i)^(1<<j)]);
                            }
                        }
                    }
                }
            }
        }
        return dp[(1<<n) - 1];
    }

    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b,a%b);
    }
}