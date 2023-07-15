import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public int maxValue(int[][] events, int k) {
        int n = events.length;
        Arrays.sort(events, Comparator.comparingInt(o -> o[1]));//按结束时间排序
        int[][] dp = new int[n+1][k+1];//dp[i][j]表示前i个最多选j个时的最大和
        for (int i = 0; i < n; i++) {
            int p = bs(events,events[i][0]);//查找结束时间小于events[i][0]的最大索引
            for (int j = 1; j <= k; j++) {
                //对于第i个，选或不选
                dp[i+1][j] = Math.max(dp[i][j],dp[p+1][j-1]+events[i][2]);
            }
        }
        return dp[n][k];
    }

    //查找小于t的最大索引
    private int bs(int[][] events,int t) {
        int l = 0,r = events.length-1;
        if (events[l][1] >= t) return -1;
        while (l < r) {
            int m = (l+r+1)/2;
            if (events[m][1] >= t) r = m-1;
            else l = m;
        }
        return l;
    }
}