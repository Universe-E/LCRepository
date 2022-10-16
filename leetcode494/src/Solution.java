class Solution {
    int count = 0;
    public int findTargetSumWays(int[] nums, int target) {
        backTrack(nums,0,target);
        return count;
    }
    private void backTrack(int[] nums, int p, int target) {
        if (p == nums.length && target == 0) {
            count++;
            return;
        }
        if (p != nums.length) {
            backTrack(nums,p + 1,target + nums[p]);
            backTrack(nums,p + 1,target - nums[p]);
        }
    }
}
