import java.util.HashSet;

class Solution {
    public boolean judgeSquareSum(int c) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i <= (int) Math.sqrt(c); i++) {
            set.add(i * i);
        }
        for (Integer i : set) {
            if (set.contains(c-i)) return true;
        }
        return false;
    }
}