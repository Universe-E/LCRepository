import java.util.Arrays;

class Solution {
    public int firstUniqChar(String s) {
        int[] v = new int[26],cnt = new int[26];
        int n = s.length(),res = -1;
        Arrays.fill(v,-1);
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (v[c-'a'] == -1) v[c-'a'] = i;
            cnt[c-'a']++;
        }
        for (int i = 0; i < 26; i++) {
            if (cnt[i] == 1) {
                if (res == -1) res = v[i];
                else res = Math.min(res,v[i]);
            }
        }
        return res;
    }
}