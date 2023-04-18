class Solution {
    public int rearrangeCharacters(String s, String target) {
        int n = s.length(), m = target.length();
        int[] cnt = new int[26],cnt2 = new int[26];
        for (int i = 0; i < n; i++) {
            cnt[s.charAt(i)-'a']++;
        }
        for (int i = 0; i < m; i++) {
            cnt2[target.charAt(i) - 'a']++;
        }
        int res = n;
        for (int i = 0; i < 26; i++) {
            if (cnt2[i] != 0) {
                res = Math.min(res,cnt[i]/cnt2[i]);
            }
        }
        return res;
    }
}