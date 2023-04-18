import java.util.HashSet;
import java.util.Set;

class Solution {
    Set<Integer> set = new HashSet<>();
    public boolean isHappy(int n) {
        int sqr = pow(n);
        if (sqr == 1) return true;
        if (set.contains(sqr)) return false;
        set.add(sqr);
        return isHappy(sqr);
    }

    private int pow(int n) {
        String s = String.valueOf(n);
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            res += Math.pow(s.charAt(i)-'0',2);
        }
        System.out.println(res);
        return res;
    }
}
