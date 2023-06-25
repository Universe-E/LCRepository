import java.util.Arrays;
import java.util.HashSet;

class Solution {
    public int maximumNumberOfStringPairs(String[] words) {
        int n = words.length;
        boolean[] v = new boolean[n];
        int res = 0;
        for (int i = 0; i < n-1; i++) {
            for (int j = i+1; j < n; j++) {
                if (!v[i] && !v[j] && words[i].contentEquals(new StringBuilder(words[j]).reverse())) {
                    res++;
                    v[i] = true;
                    v[j] = true;
                }
            }
        }
        return res;
    }
}