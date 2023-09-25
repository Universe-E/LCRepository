import java.util.TreeSet;

class Solution {
    public int minDeletions(String s) {
        int[] cnt = new int[26];
        for (char c : s.toCharArray()) {
            cnt[c-'a']++;
        }
        int res = 0;
        TreeSet<Integer> set = new TreeSet<>();
        for (int i = 0; i < 26; i++) {
            if (cnt[i] == 0) continue;
            while (set.contains(cnt[i]) && cnt[i] > 0) {
                cnt[i]--;
                res++;
            }
            if (cnt[i] > 0) set.add(cnt[i]);
        }
        return res;
    }
}