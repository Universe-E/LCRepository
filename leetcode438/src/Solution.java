import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int n = s.length(), k = p.length();
        if (k > n) return new ArrayList<>();
        int[] cnt = new int[26], cnt2 = new int[26];
        for (int i = 0; i < k; i++) {
            cnt[p.charAt(i)-'a']++;
            cnt2[s.charAt(i)-'a']++;
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n - k + 1; i++) {
            if (Arrays.equals(cnt,cnt2)) list.add(i);
            if (i != n-k) cnt2[s.charAt(i+k)-'a']++;
            cnt2[s.charAt(i)-'a']--;
        }
        return list;
    }
}