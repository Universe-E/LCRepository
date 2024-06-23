import java.util.Arrays;
import java.util.HashSet;
import java.util.TreeSet;

class Solution {
    public int minIncrementForUnique(int[] nums) {
        Arrays.sort(nums);
        int res = 0;
        TreeSet<Integer> set = new TreeSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) {
                int target = set.last()+1;
                res += target-nums[i];
                set.add(target);
            }
            else set.add(nums[i]);
        }
        return res;
    }
}