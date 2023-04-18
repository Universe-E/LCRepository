class Solution {
    public int countPalindromicSubsequence(String s) {
        char[] cs = s.toCharArray();
        int n = cs.length;
        int[] pre = new int[26], suf = new int[26];
        for (int i = n-1; i >= 0; i--) {
            suf[cs[i]-'a']++;
        }
        int res = 0;
        boolean[][] hash = new boolean[26][26];//hash[i][j]代表"jij"
        for (char c : cs) {
            int idx = c-'a';
            //处理suf,减去之前加上的值
            suf[idx]--;
            for (int i = 0; i < 26; i++) {
                if (pre[i] != 0 && suf[i] != 0 && !hash[idx][i]) {
                    res++;
                    hash[idx][i] = true;
                }
            }
            //然后处理pre,用作下一步循环
            pre[idx]++;
        }
        return res;
    }
}