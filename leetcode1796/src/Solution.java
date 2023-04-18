import java.util.TreeSet;

class Solution {
    public int secondHighest(String s) {
        TreeSet<Integer> set = new TreeSet<>((o1,o2) -> (o2-o1));
        int n = s.length();
        for (int i = 0; i < n; i++) {
            if (Character.isDigit(s.charAt(i))) set.add(s.charAt(i) - '0');
        }
        if (set.size() < 2) return -1;
        set.pollFirst();
        return set.first();
    }
}