import java.util.ArrayList;
import java.util.Arrays;

class Solution {
    public static final int M = (int) 1e9+7;
    public int numberOfWays(int n, int x) {
        ArrayList<Integer> nums = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (Math.pow(i,x) <= n) nums.add(i);
        }
        int m = nums.size();
        int[][] dp = new int[m+1][n+1];
        dp[0][0] = 1;
        for (int i = 1; i <= m; i++) {
            int p = (int) Math.pow(nums.get(i-1),x);
            for (int j = 0; j <= n; j++) {
                dp[i][j] = dp[i-1][j];
                if (j >= p) dp[i][j] = (dp[i][j]+dp[i-1][j-p])%M;
            }
        }
        return dp[m][n];
    }
}

class Solution {
    public static final int M = (int) 1e9+7;
    public int numberOfWays(int n, int x) {
        ArrayList<Integer> nums = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            int p = (int) Math.pow(i, x);
            if (p <= n) nums.add(p);
        }
        int[] dp = new int[n+1];
        dp[0] = 1;
        for (Integer num : nums) {
            for (int j = n; j >= num; j--) {
                dp[j] = (dp[j] + dp[j-num]) % M;
            }
        }
        return dp[n];
    }
}