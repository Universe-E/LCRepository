class Solution {
    public int distinctSubseqII(String s) {
        int n = s.length();
        //记录每个字母作为后缀的出现次数
        long[] suffix = new long[26];
        long[] dp = new long[n];
        suffix[s.charAt(0) - 'a'] = 1;
        dp[0] = 1;
        long res = 1;
        int M = (int) (1e9 + 7);
        for (int i = 1; i < n; i++) {
            int idx = s.charAt(i) - 'a';
            //dp[i]表示当前的方案数，不考虑重复元素时，有dp[i] = 1 + res
            dp[i] = (1 + res - suffix[idx] + M) % M;
            suffix[idx] = (suffix[idx] + dp[i]) % M;
            res = (res + dp[i]) % M;
        }
        return (int) res;
    }
}