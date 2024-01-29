class Solution {
    public int minSteps(String s, String t) {
        int res = 0;
        int[] cnt = new int[26];
        for (char c : s.toCharArray()) {
            cnt[c-'a']++;
        }
        for (char c : t.toCharArray()) {
            if (cnt[c-'a'] == 0) res++;
            else cnt[c-'a']--;
        }
        return res;
    }
}