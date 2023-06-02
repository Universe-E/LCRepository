class Solution {
    public int minimizedStringLength(String s) {
        int[] cnt = new int[26];
        for (int i = 0; i < s.length(); i++) {
            cnt[s.charAt(i)-'a']++;
        }
        int res = 0;
        for (int i = 0; i < 26; i++) {
            if (cnt[i] != 0) res++;
        }
        return res;
    }
}