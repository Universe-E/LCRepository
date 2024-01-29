import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
    public static final HashSet<Character> set =
            new HashSet<>(List.of(new Character[]{'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'}));
    public boolean halvesAreAlike(String s) {
        int all = 0,rem = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (set.contains(c)) {
                if (i < s.length()/2) rem++;
                all++;
            }
        }
        if (all % 2 != 0) return false;
        return rem * 2 == all;
    }
}