import java.util.HashSet;
import java.util.List;

class Solution {
    String[] arr = new String[8];
    HashSet<String> set = new HashSet<>();
    private static final int inf = 0x3f3f3f3f;
    String s;
    public int minimumBeautifulSubstrings(String s) {
        this.s = s;
        for (int i = 0; i <= 7; i++) {
            arr[i] = Integer.toBinaryString((int)Math.pow(5,i));
        }
        set.addAll(List.of(arr));
        int res = dfs(0);
        return res == inf ? -1 : res;
    }

    private int dfs(int i) {
        if (i == s.length()) return 0;
        int res = inf;
        for (int j = i+1; j <= s.length(); j++) {
            if (set.contains(s.substring(i,j))) res = Math.min(res,dfs(j)+1);
        }
        return res;
    }
}