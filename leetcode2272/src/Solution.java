class Solution {
    public int largestVariance(String s) {
        int n = s.length(),res = 0;
        //考察标定c1，c2的波动值，注意c1,c2可以不是出现次数最多和最少的
        for (char c1 = 'a'; c1 <= 'z'; c1++) {
            for (char c2 = 'a'; c2 <= 'z'; c2++) {
                if (c1 == c2) continue;
                int[] dp = new int[n+1];
                for (int r = 0,l = 0,pre = 10005; r < n; r++) {
                    char c = s.charAt(r);
                    if (c == c1) dp[r+1] = dp[r] + 1;
                    else if (c == c2) {
                        dp[r+1] = dp[r] - 1;
                        //缩进左边界，子串必须包含c2，子串左边界必须在当前r之前
                        //注意dp[i]统计的是[0,i)左闭右开区间的值，因此l可以取到r
                        while (l <= r) {
                            pre = Math.min(pre,dp[l]);
                            l++;
                        }
                    }
                    else dp[r+1] = dp[r];
                    res = Math.max(res,dp[r+1]-pre);
                }
            }
        }
        return res;
    }
}