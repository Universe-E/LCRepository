import java.util.TreeSet;

class Solution {
    public int findNonMinOrMax(int[] nums) {
        TreeSet<Integer> set = new TreeSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int min = set.first(),max = set.last();
        set.remove(min);
        set.remove(max);
        return set.isEmpty() ? -1 : set.first();
    }
}