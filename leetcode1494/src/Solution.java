import java.util.Arrays;

class Solution {
    public int minNumberOfSemesters(int n, int[][] relations, int k) {
        int[] pre = new int[n];
        //pre[i] represents the prerequisite courses of i
        //eg: pre[1] = 0110 means the prerequisite courses of 1 are 2,3
        for (int[] re : relations) {
            pre[re[1]-1] |= (1 << (re[0]-1));
        }
        int total = 1 << n;
        int[] dp = new int[total],cnt = new int[total];
        Arrays.fill(dp,17);
        dp[0] = 0;
        for (int i = 1; i < total; i++) {
            cnt[i] = cnt[i>>1] + (i&1);//calculate bitcount of i
        }
        //i represents courses have been taken, eg:0111 means 1,2,3 have been taken
        for (int i = 0; i < total; i++) {
            if (dp[i] > n) continue;
            int cur = 0;//what other courses can be taken after i
            //1. (i & (1<<j)) == 0
            //2. (pre[j] & i) == pre[j] means j's all prerequisite courses have been taken
            for (int j = 0; j < n; j++) {
                if ((i & (1<<j)) == 0 && (pre[j] & i) == pre[j]) cur |= (1<<j);
            }
            //enumerate subsets of cur
            for (int sub = cur; sub != 0; sub = (sub-1) & cur) {
                //based on i, calculate semesters after taken sub
                //NOTE:cnt[sub] <= k
                if (cnt[sub] <= k) dp[i|sub] = Math.min(dp[i|sub],dp[i]+1);
            }
        }
        return dp[total-1];//(total-1) means all classes have been taken
    }
}