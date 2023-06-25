import java.util.Arrays;
import java.util.HashMap;

class Solution {
    public int tallestBillboard(int[] rods) {
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,0);
        for (int rod : rods) {
            HashMap<Integer,Integer> copyMap = new HashMap<>(map);
            for (Integer key : copyMap.keySet()) {
                int val = copyMap.get(key);
                //加上该值
                map.put(key+rod,Math.max(map.getOrDefault(key+rod,0),val+rod));
                //减去该值
                map.put(key-rod,Math.max(map.getOrDefault(key-rod,0),val));
            }
        }
        return map.get(0);
    }
}

class Solution {
    public static final int inf = 0x3f3f3f3f;
    public int tallestBillboard(int[] rods) {
        int n = rods.length,mx = 0;
        for (int rod : rods) {
            mx += rod;
        }
        int[][] dp = new int[n+1][mx+1];//dp[i][j]表示前i个支架高度差为j时公共高度的最大值
        Arrays.fill(dp[0],-inf);
        dp[0][0] = 0;
        for (int i = 0; i < n; i++) {
            int rod = rods[i];
            for (int j = 0; j <= mx; j++) {
                dp[i+1][j] = dp[i][j];//不加支架的情况
                //对于当前高度差为j的情况，如果本次是加在较短边，则前一个高度差为j+rod
                //如果加在较长边，则前一个高度差为j-rod或rod-j,即abs(j-rod)
                int p1 = j+rod,p2 = Math.abs(j-rod);
                if (p1 <= mx && dp[i][p1] >= 0) dp[i+1][j] = Math.max(dp[i+1][j],dp[i][p1]+rod);
                if (p2 <= mx && dp[i][p2] >= 0) dp[i+1][j] = Math.max(dp[i+1][j],dp[i][p2]+rod);
            }
        }
        return dp[n][0]/2;
    }
}