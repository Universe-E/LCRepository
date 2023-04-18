import java.util.TreeSet;

class Solution {
    public int findClosest(String[] words, String word1, String word2) {
        int n = words.length;
        TreeSet<Integer> set1 = new TreeSet<>();
        for (int i = 0; i < n; i++) {
            if (words[i].equals(word1)) set1.add(i);
        }
        int res = n;
        for (int i = 0; i < n; i++) {
            if (words[i].equals(word2)) {
                if (set1.ceiling(i) != null) res = Math.min(res,set1.ceiling(i)-i);
                if (set1.floor(i) != null) res = Math.min(res,i-set1.floor(i));
            }
        }
        return res;
    }
}