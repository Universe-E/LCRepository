import java.util.Arrays;

class Solution {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int n = profit.length;
        int[][] arr = new int[n][3];
        for (int i = 0; i < n; i++) {
            arr[i] = new int[] {startTime[i],endTime[i],profit[i]};
        }
        //按结束时间排序，如果结束时间相同，按利润高低排序
        Arrays.sort(arr,(o1,o2) -> (o1[1]==o2[1] ? o2[2]-o1[2] : o1[1]-o2[1]));
        int[] dp = new int[n];
        dp[0] = arr[0][2];
        for (int i = 1; i < n; i++) {
            int[] cur = arr[i];
            int s = cur[0],p = cur[2];
            //找到与[s,e]区间无交叉的最近一个dp[j]，记为sump
            //由于已经按结束时间排序，此前所有结束时间不大于e
            int sump = 0;
            for (int j = i-1; j >= 0; j--) {
                if (arr[j][1] <= s) {
                    sump = dp[j];
                    break;
                }
            }
            //如果把当前任务添加进列表：总利润为sump+p，如果不添加进列表，总利润为dp[i-1]
            dp[i] = Math.max(dp[i-1],sump+p);
        }
        return dp[n-1];
    }
}