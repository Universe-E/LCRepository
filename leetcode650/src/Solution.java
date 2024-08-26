import java.util.Arrays;

class Solution {
    public int minSteps(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp,0x3f3f3f3f);
        dp[1] = 0;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j * j <= i; j++) {
                if (i % j == 0) {
                    //两个因子取最小值，例如i = 60, j = 5
                    //1、复制5，粘贴11次（总共i/j=12次）
                    //2、复制12，粘贴4次（总共j=5次）
                    //二者取最小值
                    dp[i] = Math.min(dp[i],Math.min(dp[j] + i/j,dp[i/j] + j));
                }
            }
        }
        return dp[n];
    }
}