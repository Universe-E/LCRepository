import java.util.Arrays;

class Solution {
    public String stoneGameIII(int[] stoneValue) {
        int n = stoneValue.length;
        int[] dp = new int[n+1];//dp[i]表示[i,n-1]范围内Alice拿到的净分数
        Arrays.fill(dp,Integer.MIN_VALUE);
        //全部取完后不存在净分数，默认为0
        dp[n] = 0;
        for (int i = n-1; i >= 0; i--) {
            //每次拿取分数有3种情况
            for (int j = 0,cur = 0; j < 3 && i + j < n; j++) {
                cur += stoneValue[i+j];
                dp[i] = Math.max(dp[i],cur-dp[i+j+1]);
            }
        }
        return dp[0] > 0 ? "Alice" : dp[0] == 0 ? "Tie" : "Bob";
    }
}