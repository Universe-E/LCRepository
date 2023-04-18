import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> twoEditWords(String[] queries, String[] dictionary) {
        List<String> res = new ArrayList<>();
        for (String query : queries) {
            int n = query.length();
            int cur = 101;
            for (String dict : dictionary) {
                int cnt = 0;
                for (int i = 0; i < n; i++) {
                    if (query.charAt(i) != dict.charAt(i)) cnt++;
                }
                cur = Math.min(cur,cnt);
            }
            if (cur <= 2) res.add(query);
        }
        return res;
    }
}