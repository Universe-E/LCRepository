import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public long maxTaxiEarnings(int n, int[][] rides) {
        int len = rides.length;
        //按照下车地点排序
        Arrays.sort(rides, Comparator.comparingInt(o -> o[1]));
        long[] dp = new long[len];
        dp[0] = rides[0][1]-rides[0][0]+rides[0][2];
        for (int i = 1; i < len; i++) {
            int s = rides[i][0], p = rides[i][1]-rides[i][0]+rides[i][2];
            //二分查找，找到右边界小于等于s的最大arr[i][1]对应的i，记为t
            int l = -1,r = i-1;
            while (l < r) {
                int mid = l+(r-l+1)/2;
                if (rides[mid][1] <= s) l = mid;
                else r = mid-1;
            }
            //两种情况：1、不载第i个客人，此时dp[i]=dp[i-1]；2、载上第i个客人，此时dp[i]=p+dp[l]
            dp[i] = Math.max(dp[i-1],p+(l==-1 ? 0 : dp[l]));
        }
        return dp[len-1];
    }
}

class Solution {
    public long maxTaxiEarnings(int n, int[][] rides) {
        //按照下车地点排序
        Arrays.sort(rides, Comparator.comparingInt(o -> o[1]));
        long[] dp = new long[n+1];
        int end = 0;
        for (int[] ride : rides) {
            while (end <= n && end < ride[1]) {
                end++;
                if (end <= n) dp[end] = dp[end - 1];
            }
            if (end == ride[1]) {
                int start = ride[0], money = end - start + ride[2];
                dp[end] = Math.max(dp[end], dp[start] + money);
            }
        }
        while (end <= n) {
            end++;
            if (end <= n) dp[end] = dp[end - 1];
        }
        return dp[n];
    }
}