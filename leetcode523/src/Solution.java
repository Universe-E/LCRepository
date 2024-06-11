import java.util.HashSet;

class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        int n = nums.length, sum = 0;
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            sum += num;
            if (set.contains(sum % k)) return true;
            set.add((sum - num) % k);
        }
        return false;
    }
}