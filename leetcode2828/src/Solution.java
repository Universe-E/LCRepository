import java.util.List;

class Solution {
    public boolean isAcronym(List<String> words, String s) {
        int n = words.size();
        if (s.length() != n) return false;
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (words.get(i).charAt(0) != c) return false;
        }
        return true;
    }
}