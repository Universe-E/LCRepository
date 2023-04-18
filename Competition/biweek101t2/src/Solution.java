class Solution {
    public int maximumCostSubstring(String s, String chars, int[] vals) {
        int len = s.length(), n = vals.length;
        int[] cnt = new int[26];
        for (int i = 0; i < 26; i++) {
            cnt[i] = -1001;
        }
        for (int i = 0; i < n; i++) {
            cnt[chars.charAt(i)-'a'] = vals[i];
        }
        for (int i = 0; i < 26; i++) {
            if (cnt[i] == -1001) cnt[i] = i+1;
        }
        int l = 0,res = 0,cur = 0;
        for (int r = 0; r < len; r++) {
            int i = s.charAt(r)-'a';
            cur += cnt[i];
            while (l <= r && cur <= 0) {
                int li = s.charAt(l) - 'a';
                cur -= cnt[li];
                l++;
                res = Math.max(res,cur);
            }
            res = Math.max(res, cur);
        }
        return res;
    }
}