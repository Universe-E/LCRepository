import java.util.HashSet;
import java.util.List;

class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> set = new HashSet<>(wordDict);
        int n = s.length();
        boolean[] valids = new boolean[n + 1];
        valids[0] = true;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                String cur = s.substring(j,i);
                //注意！不仅从j到i的子串要包含集合中单词，当前点也要能拆分才行
                if (valids[j] && set.contains(cur)) {
                    valids[i] = true;
                    break;
                }
            }
        }
        return valids[n];
    }
}
