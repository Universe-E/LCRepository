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
            //找到与[s,e]区间无交叉的最近一个dp[lastEnd]，如果没有符合条件的（即lastEnd=-1)，则值为0
            int lastEnd = bs(arr,s,i);
            dp[i] = Math.max(dp[i-1],(lastEnd == -1 ? 0 : dp[lastEnd])+p);
        }
        return dp[n-1];
    }

    private int bs(int[][] arr, int start, int i) {
        int l = 0,r = i-1;
        if (arr[l][1] > start) return -1;
        while (l < r) {
            int m = (l+r+1)/2;
            if (arr[m][1] <= start) l = m;
            else r = m-1;
        }
        return l;
    }
}