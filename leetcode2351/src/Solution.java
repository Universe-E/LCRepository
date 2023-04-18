import java.util.Random;

class Solution {
    public char repeatedCharacter(String s) {
        int[] cnt = new int[26];
        int n = s.length();
        for (int i = 0; i < n; i++) {
            if (cnt[s.charAt(i)-'a'] != 0) return s.charAt(i);
            cnt[s.charAt(i)-'a']++;
        }
        return ' ';
    }
}