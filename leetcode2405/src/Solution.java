import java.util.HashSet;

class Solution {
    public int partitionString(String s) {
        int n = s.length(),cnt = 0;
        HashSet<Character> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (!set.contains(c)) {
                set.add(c);
            }
            else {
                set.clear();
                set.add(c);
                cnt++;
            }
        }
        return cnt+1;
    }
}