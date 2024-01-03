import java.util.Arrays;

class Solution {
    public int findContentChildren(int[] g, int[] s) {
        int res = 0;
        Arrays.sort(g);
        Arrays.sort(s);
        for (int i = 0,j = 0; i < g.length; i++) {
            while (j < s.length && s[j] < g[i]) j++;
            if (j == s.length) break;
            res++;
            j++;
        }
        return res;
    }
}