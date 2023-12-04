class Solution {
    public int countCharacters(String[] words, String chars) {
        int[] cnt = new int[26];
        int res = 0;
        for (char c : chars.toCharArray()) {
            cnt[c-'a']++;
        }
        for (String w : words) {
            int[] cnt2 = new int[26];
            for (char c : w.toCharArray()) {
                cnt2[c-'a']++;
            }
            boolean ok = true;
            for (int i = 0; i < 26; i++) {
                if (cnt2[i] > cnt[i]) {
                    ok = false;
                    break;
                }
            }
            if (ok) res += w.length();
        }
        return res;
    }
}