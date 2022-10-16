import java.util.TreeSet;

class Solution {
    public int findMaxK(int[] nums) {
        TreeSet<Integer> set = new TreeSet<>((o1,o2) -> (o2 - o1));
        for (int num : nums) {
            set.add(num);
        }
        for (Integer p : set) {
            if (p > 0 && set.contains(-p)) return p;
        }
        return -1;
    }
}