import java.util.HashSet;
import java.util.List;

class Solution {
    public long distinctNames(String[] ideas) {
        var set = new HashSet<>(List.of(ideas));
        int[][] cnt = new int[26][26];
        //cnt[i][j]表示首字母从i变到j后，有多少个满足条件的结果
        for (String idea : ideas) {
            char c = idea.charAt(0);
            StringBuilder sb = new StringBuilder(idea);
            for (int j = 0; j < 26; j++) {
                sb.setCharAt(0,(char) ('a'+j));
                if (!set.contains(sb.toString())) cnt[c-'a'][j]++;
            }
        }
        long res = 0;
        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < 26; j++) {
                res += (long)cnt[i][j]*cnt[j][i];
            }
        }
        return res;
    }
}