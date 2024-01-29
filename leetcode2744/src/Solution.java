import java.util.HashMap;
import java.util.HashSet;

class Solution {
    public int maximumNumberOfStringPairs(String[] words) {
        HashSet<String> set = new HashSet<>();
        int res = 0;
        for (String w : words) {
            if (set.contains(new StringBuilder(w).reverse().toString())) res++;
            set.add(w);
        }
        return res;
    }
}