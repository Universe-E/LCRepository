import java.util.HashMap;
import java.util.HashSet;

class Solution {
    public boolean repeatedSubstringPattern(String s) {
        int n = s.length();
        HashSet<String> set = new HashSet<>();
        for (int i = 1; i <= n/2; i++) {
            if (n%i != 0) continue;
            set.add(s.substring(0,i));
        }
        for (String s1 : set) {
            if (s.replaceAll(s1,"").length()==0) return true;
        }
        return false;
    }
}