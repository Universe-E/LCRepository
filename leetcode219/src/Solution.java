import java.util.HashSet;

class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        int n = nums.length;
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            if (set.contains(nums[i])) return true;
            set.add(nums[i]);
            //保持record中有k个元素
            if (set.size() == k+1) set.remove(nums[i-k]);
        }
        return false;
    }
}