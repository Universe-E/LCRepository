import java.util.HashSet;
import java.util.Set;

class Solution {
    Set<Integer> set = new HashSet<>();
    public boolean isHappy(int n) {
        char[] chars = String.valueOf(n).toCharArray();
        int res = 0;
        while (res != 1) {
            res = 0;
            for (char c : chars) res += Math.pow(c - '0', 2);
            //如果set中已经包含了res，则直接返回false
            if (set.contains(res)) return false;
            set.add(res);
            chars = String.valueOf(res).toCharArray();
        }
        return true;
    }

    public static void main(String[] args) {
        new Solution().isHappy(19);
    }
}
