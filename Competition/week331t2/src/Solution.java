import java.util.HashSet;

class Solution {
    private static final HashSet<Character> set = new HashSet<>();
    static {
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');
    }
    public int[] vowelStrings(String[] words, int[][] queries) {
        int n = words.length, len = queries.length;
        int[] pre = new int[n+1];
        for (int i = 1; i <= n; i++) {
            String s = words[i-1];
            pre[i] = pre[i-1];
            if (set.contains(s.charAt(0)) && set.contains(s.charAt(s.length()-1))) pre[i]++;
        }
        int[] res = new int[len];
        for (int i = 0; i < len; i++) {
            res[i] = pre[queries[i][1]+1] - pre[queries[i][0]];
        }
        return res;
    }
}