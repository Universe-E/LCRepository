import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public int maxProduct(String[] words) {
        Arrays.sort(words, Comparator.comparingInt(String::length).reversed());
        int n = words.length;
        int[] mask = new int[n];
        for (int i = 0; i < n; i++) {
            for (char c : words[i].toCharArray()) {
                mask[i] |= (1<<(c-'a'));
            }
        }
        int res = 0;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i+1; j < n; j++) {
                if ((mask[i] | mask[j]) == mask[i]+mask[j]) res = Math.max(res,words[i].length()*words[j].length());
            }
        }
        return res;
    }
}