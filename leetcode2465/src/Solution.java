import java.util.Arrays;
import java.util.HashSet;

class Solution {
    public int distinctAverages(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length,l = 0,r = n-1;
        HashSet<Integer> set = new HashSet<>();
        while (l < r) set.add(nums[l++]+nums[r--]);
        return set.size();
    }
}