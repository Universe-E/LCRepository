import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int n = s.length(), k = p.length();
        int[] cnt = new int[26];
        for (int i = 0; i < k; i++) {
            cnt[p.charAt(i) - 'a']++;
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n - k + 1; i++) {
            int[] cur = new int[26];
            for (int j = i; j < i + k; j++) {
                cur[s.charAt(j) - 'a']++;
            }
            if (Arrays.equals(cur,cnt)) list.add(i);
        }
        return list;
    }
}