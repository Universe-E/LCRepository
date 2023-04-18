import java.util.Arrays;

class Solution {
    public int bestTeamScore(int[] scores, int[] ages) {
        int n = scores.length;
        Integer[] idx = new Integer[n];
        for (int i = 0; i < n; i++) {
            idx[i] = i;
        }
        Arrays.sort(idx,(o1,o2) -> (ages[o1]==ages[o2] ? (scores[o1]-scores[o2]) : (ages[o1]-ages[o2])));
        int[] dp = new int[n];
        int res = 0;
        for (int i = 0; i < n; i++) {
            dp[i] = scores[idx[i]];
            for (int j = i-1; j >= 0; j--) {
                //idx已经按年龄排序，此时只要不比idx[i]得分高就满足条件
                if (scores[idx[j]] <= scores[idx[i]]) dp[i] = Math.max(dp[i],scores[idx[i]] + dp[j]);
            }
            res = Math.max(res,dp[i]);
        }
        return res;
    }
}