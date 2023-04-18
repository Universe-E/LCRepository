
class Solution {
    public boolean isIdealPermutation(int[] nums) {
        int n = nums.length;
        //global inversions include local inversions
        //for all the nums[i],no more than 1 word from nums[0] to nums[i-1] is larger than nums[i]
        for (int i = 0; i < n; i++) {
            if (Math.abs(nums[i] - i) > 1) return false;
        }
        return true;
    }
}