import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;
import java.util.TreeSet;

class Solution {
    public List<Integer> relocateMarbles(int[] nums, int[] moveFrom, int[] moveTo) {
        TreeSet<Integer> set = new TreeSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int len = moveFrom.length;
        for (int i = 0; i < len; i++) {
            set.remove(moveFrom[i]);
            set.add(moveTo[i]);
        }
        return new ArrayList<>(set);
    }
}