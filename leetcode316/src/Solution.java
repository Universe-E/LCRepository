import java.util.ArrayDeque;

class Solution {
    public String removeDuplicateLetters(String s) {
        int[] cnt = new int[26];
        for (char c : s.toCharArray()) {
            cnt[c-'a']++;
        }
        var q = new ArrayDeque<Character>();
        int[] cnt2 = new int[26];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            //if no c in current queue, add it by mono-stack
            if (cnt2[c-'a'] == 0) {
                while (!q.isEmpty() && c < q.peekLast() && cnt[q.peekLast()-'a'] > 0) cnt2[q.pollLast()-'a']--;
                q.addLast(c);
                cnt2[c-'a']++;
            }
            cnt[c-'a']--;
        }
        StringBuilder res = new StringBuilder();
        while (!q.isEmpty()) res.append(q.pollFirst());
        return res.toString();
    }
}