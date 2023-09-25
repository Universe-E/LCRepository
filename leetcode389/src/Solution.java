class Solution {
    public char findTheDifference(String s, String t) {
        String total = s + t;
        if (total.length() == 1) return total.charAt(0);
        int res = total.charAt(0) - 'a';
        for (int i = 1; i < total.length(); i++) {
            res ^= total.charAt(i) - 'a';
        }
        return (char)('a' + res);
    }
}

class Solution {
    public char findTheDifference(String s, String t) {
        int[] cnt = new int[26];
        for (int i = 0; i < s.length(); i++) {
            cnt[s.charAt(i)-'a']++;
        }
        for (int i = 0; i < t.length(); i++) {
            cnt[t.charAt(i)-'a']--;
        }
        for (int i = 0; i < 26; i++) {
            if (cnt[i] == -1) return (char) ('a'+i);
        }
        return 'a';
    }
}
