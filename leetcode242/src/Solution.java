class Solution {
    public boolean isAnagram(String s, String t) {
        int n1 = s.length(),n2 = t.length();
        if (n1 != n2) return false;
        int[] cnt = new int[26];
        for (int i = 0; i < n1; i++) {
            cnt[s.charAt(i)-'a']++;
            cnt[t.charAt(i)-'a']--;
        }
        for (int i = 0; i < 26; i++) {
            if (cnt[i] != 0) return false;
        }
        return true;
    }
}