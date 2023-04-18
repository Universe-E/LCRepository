import java.util.Arrays;
import java.util.HashMap;

class Solution {
    public String largestNumber(int[] cost, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        //map去重
        for (int i = 0; i < cost.length; i++) map.put(cost[i],i+1);
        String[] dp = new String[target+1];
        //初始化dp
        Arrays.fill(dp,"");
        for (Integer k : map.keySet()) {
            if (k > target) continue;
            int v = map.get(k);
            dp[target-k] += String.valueOf(v);
        }
        for (int i = target; i >= 0; i--) {
            if (dp[i].length() > 0) {
                for (Integer k : map.keySet()) {
                    if (k > i) continue;
                    int v = map.get(k);
                    String cur = dp[i]+v;
                    if (cur.length() > dp[i-k].length()) dp[i-k] = cur;
                    else if (cur.length()==dp[i-k].length() && cur.compareTo(dp[i-k]) > 0) dp[i-k] = cur;
                }
            }
        }
        return dp[0].length()==0 ? "0" : dp[0];
    }
}

class Solution {
    public String largestNumber(int[] cost, int target) {
        String[] dp = new String[target+1];
        //初始化dp
        Arrays.fill(dp,"");
        for (int i = 0; i < cost.length; i++) {
            if (cost[i] > target) continue;
            dp[target-cost[i]] = String.valueOf(i+1);
        }
        for (int i = target; i >= 0; i--) {
            if (dp[i].length() > 0) {
                for (int j = 0; j < cost.length; j++) {
                    int c = cost[j];
                    if (c > i) continue;
                    String cur = dp[i]+ (j+1);
                    if (cur.length() > dp[i-c].length()) dp[i-c] = cur;
                    else if (cur.length()==dp[i-c].length() && cur.compareTo(dp[i-c]) > 0) dp[i-c] = cur;
                }
            }
        }
        return dp[0].length()==0 ? "0" : dp[0];
    }
}