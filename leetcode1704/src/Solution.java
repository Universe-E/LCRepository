import java.util.HashSet;
import java.util.Set;

class Solution {
    public static final char[] cs = new char[] {'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'};
    public boolean halvesAreAlike(String s) {
        int n = s.length();
        String a = s.substring(0,n/2), b = s.substring(n/2);
        Set<Character> set = new HashSet<>();
        for (char c : cs) {
            set.add(c);
        }
        int cnt1 = 0, cnt2 = 0;
        for (int i = 0; i < n / 2; i++) {
            if (set.contains(a.charAt(i))) cnt1++;
            if (set.contains(b.charAt(i))) cnt2++;
        }
        return cnt1 == cnt2;
    }
}